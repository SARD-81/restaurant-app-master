package com.ramin.restaurantapp.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentFoodCollectionBinding
import com.ramin.restaurantapp.model.FoodItem
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.ui.common.FoodAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

enum class FoodCollectionType { LIKED, SAVED }

class FoodCollectionFragment : Fragment() {

    private var _binding: FragmentFoodCollectionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        val application = requireActivity().application as RestaurantApplication
        RestaurantViewModel.Factory(application.repository, application.preferences)
    }

    private lateinit var collectionType: FoodCollectionType
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val typeName = requireArguments().getString(ARG_COLLECTION_TYPE) ?: FoodCollectionType.LIKED.name
        collectionType = FoodCollectionType.valueOf(typeName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFoodCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHero()
        setupRecycler()
        observeCollection()
    }

    private fun setupHero() {
        val config = when (collectionType) {
            FoodCollectionType.LIKED -> CollectionUiConfig(
                title = getString(R.string.collection_liked_title),
                subtitle = getString(R.string.collection_liked_subtitle),
                emptyText = getString(R.string.collection_empty_liked),
                iconRes = R.drawable.ic_favorite_filled,
                backgroundRes = R.drawable.collection_like_background,
                emptyIconRes = R.drawable.ic_favorite_border,
                emptyIconTint = R.color.secondary,
                badgeBuilder = { foodItem ->
                    FoodAdapter.FoodBadge(
                        iconRes = R.drawable.ic_favorite_filled,
                        backgroundTint = R.color.secondary,
                        iconTint = R.color.on_secondary,
                        contentDescription = getString(R.string.favorite_badge_content_description)
                    )
                }
            )

            FoodCollectionType.SAVED -> CollectionUiConfig(
                title = getString(R.string.collection_saved_title),
                subtitle = getString(R.string.collection_saved_subtitle),
                emptyText = getString(R.string.collection_empty_saved),
                iconRes = R.drawable.ic_bookmark_filled,
                backgroundRes = R.drawable.collection_saved_background,
                emptyIconRes = R.drawable.ic_bookmark_border,
                emptyIconTint = R.color.primary,
                badgeBuilder = { _ ->
                    FoodAdapter.FoodBadge(
                        iconRes = R.drawable.ic_bookmark_filled,
                        backgroundTint = R.color.primary,
                        iconTint = R.color.on_primary,
                        contentDescription = getString(R.string.saved_badge_content_description)
                    )
                }
            )
        }
        binding.collectionHeroContent.setBackgroundResource(config.backgroundRes)
        binding.collectionHeroIcon.setImageResource(config.iconRes)
        binding.collectionTitle.text = config.title
        binding.collectionSubtitle.text = config.subtitle
        binding.collectionEmptyText.text = config.emptyText
        binding.collectionEmptyIcon.setImageResource(config.emptyIconRes)
        binding.collectionEmptyIcon.setColorFilter(ContextCompat.getColor(requireContext(), config.emptyIconTint))
        adapter = FoodAdapter(
            onItemSelected = { item -> navigateToDetail(item) },
            badgeProvider = config.badgeBuilder
        )
    }

    private fun setupRecycler() {
        binding.collectionRecyclerView.apply {
            adapter = this@FoodCollectionFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeCollection() {
        val liveData = when (collectionType) {
            FoodCollectionType.LIKED -> viewModel.likedFoodsLiveData()
            FoodCollectionType.SAVED -> viewModel.savedFoodsLiveData()
        }
        liveData.observe(viewLifecycleOwner) { foods ->
            renderCollection(foods)
        }
    }

    private fun renderCollection(items: List<FoodItem>) {
        adapter.submitList(items)
        binding.collectionRecyclerView.isVisible = items.isNotEmpty()
        binding.collectionEmptyState.isVisible = items.isEmpty()
        val countText = if (items.isEmpty()) {
            getString(R.string.no_items_available)
        } else {
            resources.getQuantityString(
                R.plurals.collection_result_count,
                items.size,
                items.size
            )
        }
        binding.collectionCount.text = countText
    }

    private fun navigateToDetail(item: FoodItem) {
        val args = bundleOf("foodId" to item.id)
        findNavController().navigate(R.id.foodDetailFragment, args)
    }

    override fun onResume() {
        super.onResume()
        val titleRes = when (collectionType) {
            FoodCollectionType.LIKED -> R.string.menu_liked
            FoodCollectionType.SAVED -> R.string.menu_saved
        }
        (requireActivity() as? MainActivity)?.supportActionBar?.title = getString(titleRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private data class CollectionUiConfig(
        val title: String,
        val subtitle: String,
        val emptyText: String,
        val iconRes: Int,
        val backgroundRes: Int,
        val emptyIconRes: Int,
        val emptyIconTint: Int,
        val badgeBuilder: (FoodItem) -> FoodAdapter.FoodBadge,
    )

    companion object {
        const val ARG_COLLECTION_TYPE = "collectionType"
    }
}
