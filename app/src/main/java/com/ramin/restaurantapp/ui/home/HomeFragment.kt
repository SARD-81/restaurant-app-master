package com.ramin.restaurantapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentHomeBinding
import com.ramin.restaurantapp.model.CategorySummary
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.ui.common.CategoryAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory((requireActivity().application as RestaurantApplication).repository)
    }

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        observeCategories()
    }

    private fun setupRecycler() {
        categoryAdapter = CategoryAdapter { category -> handleCategorySelection(category) }
        binding.categoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun observeCategories() {
        viewModel.categoriesLiveData().observe(viewLifecycleOwner) { categories ->
            categoryAdapter.submitList(categories)
        }
    }

    private fun handleCategorySelection(category: CategorySummary) {
        if (category.hasSubcategories) {
            val args = bundleOf(
                "category" to category.name,
                "title" to category.name
            )
            findNavController().navigate(R.id.action_home_to_category, args)
        } else {
            val args = bundleOf(
                "category" to category.name,
                "subcategory" to null,
                "title" to category.name
            )
            findNavController().navigate(R.id.action_home_to_food_list, args)
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as? MainActivity)?.supportActionBar?.title = getString(R.string.app_name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
