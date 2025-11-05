package com.ramin.restaurantapp.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentFoodListBinding
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.ui.common.FoodAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class FoodListFragment : Fragment() {

    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory((requireActivity().application as RestaurantApplication).repository)
    }

    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = requireArguments().getString("category").orEmpty()
        val subcategory = requireArguments().getString("subcategory")
        val title = requireArguments().getString("title").orEmpty()
        binding.foodListTitle.text = title
        binding.categoryChip.text = category
        if (subcategory.isNullOrBlank()) {
            binding.foodListSubtitle.text = getString(R.string.food_list_subtitle_category, category)
            binding.subcategoryChip.visibility = View.GONE
        } else {
            binding.foodListSubtitle.text = getString(R.string.food_list_subtitle_subcategory, subcategory)
            binding.subcategoryChip.visibility = View.VISIBLE
            binding.subcategoryChip.text = subcategory
        }
        setupRecycler()
        observeFoods(category, subcategory)
    }

    private fun setupRecycler() {
        adapter = FoodAdapter { foodItem ->
            val args = bundleOf("foodId" to foodItem.id)
            findNavController().navigate(R.id.action_food_list_to_food_detail, args)
        }
        binding.foodRecyclerView.apply {
            adapter = this@FoodListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeFoods(category: String, subcategory: String?) {
        viewModel.foodsLiveData(category, subcategory).observe(viewLifecycleOwner) { foods ->
            adapter.submitList(foods)
            binding.emptyView.visibility = if (foods.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as? MainActivity)?.supportActionBar?.title = binding.foodListTitle.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
