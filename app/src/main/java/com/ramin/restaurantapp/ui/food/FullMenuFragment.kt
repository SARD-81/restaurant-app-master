package com.ramin.restaurantapp.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentFullMenuBinding
import com.ramin.restaurantapp.databinding.ItemCategoryChipBinding
import com.ramin.restaurantapp.model.CategorySummary
import com.ramin.restaurantapp.model.FoodItem
import com.ramin.restaurantapp.ui.common.FoodAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class FullMenuFragment : Fragment() {

    private var _binding: FragmentFullMenuBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        val application = requireActivity().application as RestaurantApplication
        RestaurantViewModel.Factory(application.repository, application.preferences)
    }

    private lateinit var adapter: FoodAdapter
    private var allFoods: List<FoodItem> = emptyList()
    private var selectedCategory: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFullMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        observeCategories()
        observeFullMenu()
    }

    private fun setupRecycler() {
        adapter = FoodAdapter(
            onItemSelected = { foodItem ->
                val args = bundleOf("foodId" to foodItem.id)
                findNavController().navigate(R.id.action_full_menu_to_food_detail, args)
            },
            badgeProvider = { foodItem -> badgeForFood(foodItem) }
        )
        binding.fullMenuRecyclerView.apply {
            adapter = this@FullMenuFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.likedIdsLiveData.observe(viewLifecycleOwner) { refreshVisibleBadges() }
        viewModel.savedIdsLiveData.observe(viewLifecycleOwner) { refreshVisibleBadges() }
    }

    private fun observeCategories() {
        viewModel.categoriesLiveData().observe(viewLifecycleOwner) { categories ->
            renderCategoryChips(categories.sortedBy { it.name })
        }
    }

    private fun observeFullMenu() {
        viewModel.fullMenuLiveData().observe(viewLifecycleOwner) { foods ->
            allFoods = foods
            applyFilter()
        }
    }

    private fun renderCategoryChips(categories: List<CategorySummary>) {
        binding.categoryFilterChipGroup.setOnCheckedChangeListener(null)
        binding.categoryFilterChipGroup.removeAllViews()
        val inflater = LayoutInflater.from(requireContext())
        val chips = mutableListOf<Pair<String?, Chip>>()
        val allChipBinding = ItemCategoryChipBinding.inflate(inflater, binding.categoryFilterChipGroup, false)
        val allChip = allChipBinding.categoryChip.apply {
            text = getString(R.string.full_menu_filter_all)
            isCheckable = true
            tag = null
        }
        binding.categoryFilterChipGroup.addView(allChip)
        chips.add(null to allChip)
        categories.forEach { category ->
            val chipBinding = ItemCategoryChipBinding.inflate(inflater, binding.categoryFilterChipGroup, false)
            val chip = chipBinding.categoryChip.apply {
                text = category.name
                isCheckable = true
            }
            chip.tag = category.name
            binding.categoryFilterChipGroup.addView(chip)
            chips.add(category.name to chip)
        }
        val availableCategories = categories.map { it.name }
        if (selectedCategory != null && selectedCategory !in availableCategories) {
            selectedCategory = null
        }
        val targetChip = chips.firstOrNull { it.first == selectedCategory }?.second ?: allChip
        binding.categoryFilterChipGroup.check(targetChip.id)
        binding.categoryFilterChipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            selectedCategory = chip?.tag as? String
            applyFilter()
        }
        applyFilter()
    }

    private fun applyFilter() {
        val filteredList = if (selectedCategory.isNullOrBlank()) {
            allFoods
        } else {
            allFoods.filter { it.category == selectedCategory }
        }
        adapter.submitList(filteredList)
        binding.fullMenuRecyclerView.isVisible = filteredList.isNotEmpty()
        binding.fullMenuEmptyView.isVisible = filteredList.isEmpty()
        binding.fullMenuCount.text = resources.getQuantityString(
            R.plurals.full_menu_result_count,
            filteredList.size,
            filteredList.size
        )
    }

    private fun badgeForFood(item: FoodItem): FoodAdapter.FoodBadge? {
        return when {
            viewModel.isLiked(item.id) -> FoodAdapter.FoodBadge(
                iconRes = R.drawable.ic_favorite_filled,
                backgroundTint = R.color.secondary,
                iconTint = R.color.on_secondary,
                contentDescription = getString(R.string.favorite_badge_content_description)
            )

            viewModel.isSaved(item.id) -> FoodAdapter.FoodBadge(
                iconRes = R.drawable.ic_bookmark_filled,
                backgroundTint = R.color.primary,
                iconTint = R.color.on_primary,
                contentDescription = getString(R.string.saved_badge_content_description)
            )

            else -> null
        }
    }

    private fun refreshVisibleBadges() {
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}