package com.ramin.restaurantapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
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
        binding.foodTitle.text = foodItem.name
        binding.foodDescription.text = foodItem.description
        binding.mediaPager.adapter = MediaPagerAdapter(foodItem.media)
        (requireActivity() as? MainActivity)?.supportActionBar?.title = foodItem.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
