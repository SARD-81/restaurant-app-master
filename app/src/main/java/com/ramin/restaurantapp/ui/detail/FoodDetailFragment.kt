package com.ramin.restaurantapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentFoodDetailBinding
import com.ramin.restaurantapp.model.FoodItem
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class FoodDetailFragment : Fragment() {

    private var _binding: FragmentFoodDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory((requireActivity().application as RestaurantApplication).repository)
    }

    private var mediaAdapter: MediaPagerAdapter? = null
    private var tabMediator: TabLayoutMediator? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFoodDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foodId = requireArguments().getInt("foodId")
        observeFood(foodId)
    }

    private fun observeFood(foodId: Int) {
        viewModel.foodDetailLiveData(foodId).observe(viewLifecycleOwner) { item ->
            bindFood(item)
        }
    }

    private fun bindFood(foodItem: FoodItem) {
        binding.postTitle.text = getString(R.string.app_name)
        binding.postSubtitle.text = if (foodItem.subcategory.isNullOrBlank()) {
            foodItem.category
        } else {
            getString(R.string.food_detail_subtitle_format, foodItem.category, foodItem.subcategory)
        }
        binding.foodTitle.text = foodItem.name
        binding.foodDescription.text = foodItem.description
        binding.detailCategoryChip.text = foodItem.category
        if (foodItem.subcategory.isNullOrBlank()) {
            binding.detailSubcategoryChip.visibility = View.GONE
        } else {
            binding.detailSubcategoryChip.visibility = View.VISIBLE
            binding.detailSubcategoryChip.text = foodItem.subcategory
        }
        mediaAdapter = MediaPagerAdapter(foodItem.media)
        binding.mediaPager.apply {
            adapter = mediaAdapter
            offscreenPageLimit = 3
        }
        tabMediator?.detach()
        tabMediator = TabLayoutMediator(binding.mediaIndicator, binding.mediaPager) { _, _ -> }
        tabMediator?.attach()
        binding.mediaIndicator.isVisible = foodItem.media.size > 1

        binding.likeButton.setOnClickListener {
            Snackbar.make(
                binding.root,
                getString(R.string.food_detail_like_feedback, foodItem.name),
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.saveButton.setOnClickListener {
            Snackbar.make(
                binding.root,
                getString(R.string.food_detail_save_feedback, foodItem.name),
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.shareButton.setOnClickListener {
            shareFood(foodItem)
        }
        binding.reserveButton.setOnClickListener {
            Snackbar.make(
                binding.root,
                getString(R.string.reserve_snackbar_message, foodItem.name),
                Snackbar.LENGTH_SHORT
            ).show()
        }
        (requireActivity() as? MainActivity)?.supportActionBar?.title = foodItem.name
    }

    private fun shareFood(foodItem: FoodItem) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, foodItem.name)
            putExtra(Intent.EXTRA_TEXT, getString(R.string.food_detail_share_text, foodItem.name))
        }
        startActivity(Intent.createChooser(shareIntent, getString(R.string.food_detail_actions_share)))
    }

    override fun onDestroyView() {
        binding.mediaPager.adapter = null
        tabMediator?.detach()
        tabMediator = null
        mediaAdapter = null
        super.onDestroyView()
        _binding = null
    }
}
