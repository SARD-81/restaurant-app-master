package com.ramin.restaurantapp.ui.category

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
import com.ramin.restaurantapp.databinding.FragmentCategoryBinding
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.ui.common.SubcategoryAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory((requireActivity().application as RestaurantApplication).repository)
    }

    private lateinit var adapter: SubcategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = requireArguments().getString("category").orEmpty()
        val title = requireArguments().getString("title").orEmpty()
        binding.categoryTitle.text = title
        setupRecycler(category)
        observeSubcategories(category)
    }

    private fun setupRecycler(category: String) {
        adapter = SubcategoryAdapter { subcategory ->
            val args = bundleOf(
                "category" to category,
                "subcategory" to subcategory.name,
                "title" to subcategory.name
            )
            findNavController().navigate(R.id.action_category_to_food_list, args)
        }
        binding.subcategoryRecyclerView.apply {
            adapter = this@CategoryFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun observeSubcategories(category: String) {
        viewModel.subcategoriesLiveData(category).observe(viewLifecycleOwner) { subcategories ->
            adapter.submitList(subcategories)
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as? MainActivity)?.supportActionBar?.title = binding.categoryTitle.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
