package com.ramin.restaurantapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.RestaurantApplication
import com.ramin.restaurantapp.databinding.FragmentHomeBinding
import com.ramin.restaurantapp.model.CategorySummary
import com.ramin.restaurantapp.ui.MainActivity
import com.ramin.restaurantapp.ui.common.CategoryAdapter
import com.ramin.restaurantapp.ui.common.CategoryChipAdapter
import com.ramin.restaurantapp.ui.common.FoodAdapter
import com.ramin.restaurantapp.viewmodel.RestaurantViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by activityViewModels {
        val application = requireActivity().application as RestaurantApplication
        RestaurantViewModel.Factory(application.repository, application.preferences)
    }

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryChipAdapter: CategoryChipAdapter
    private lateinit var searchAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategoryGrid()
        setupCollections()
        setupQuickCategories()
        setupSearchSection()
        observeCategories()
        observeCollections()
        observeSearchResults()
    }

    private fun setupCategoryGrid() {
        categoryAdapter = CategoryAdapter { category -> handleCategorySelection(category) }
        binding.categoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            isNestedScrollingEnabled = false
        }
//        binding.fullMenuButton.setOnClickListener {
//            findNavController().navigate(R.id.action_home_to_full_menu)
//        }
    }

    private fun setupCollections() {
        binding.likedCollectionCard.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_liked_collection)
        }
        binding.savedCollectionCard.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_saved_collection)
        }
    }

    private fun setupQuickCategories() {
        categoryChipAdapter = CategoryChipAdapter { category -> handleCategorySelection(category) }
        binding.quickCategoryRecyclerView.apply {
            adapter = categoryChipAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            isNestedScrollingEnabled = false
        }
    }

    private fun setupSearchSection() {
        searchAdapter = FoodAdapter(
            onItemSelected = { foodItem ->
                val args = bundleOf("foodId" to foodItem.id)
                findNavController().navigate(R.id.action_home_to_food_detail, args)
            },
            badgeProvider = null
        )
        binding.searchResultsRecyclerView.apply {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext())
            isNestedScrollingEnabled = false
        }
        binding.searchEditText.apply {
            doOnTextChanged { text, _, _, _ ->
                viewModel.updateSearchQuery(text?.toString().orEmpty())
            }
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard()
                    true
                } else {
                    false
                }
            }
        }
        binding.searchInputLayout.setEndIconOnClickListener {
            binding.searchEditText.setText("")
            binding.searchEditText.clearFocus()
            hideKeyboard()
        }
    }

    private fun observeCategories() {
        viewModel.categoriesLiveData().observe(viewLifecycleOwner) { categories ->
            categoryAdapter.submitList(categories)
            categoryChipAdapter.submitList(categories.sortedByDescending { it.itemCount })
        }
    }

    private fun observeCollections() {
        viewModel.likedFoodsLiveData().observe(viewLifecycleOwner) { likedItems ->
            if (likedItems.isEmpty()) {
                binding.likedCollectionCount.text = getString(R.string.home_liked_empty)
                binding.likedCollectionCard.alpha = 0.8f
            } else {
                binding.likedCollectionCount.text = resources.getQuantityString(
                    R.plurals.collection_result_count,
                    likedItems.size,
                    likedItems.size
                )
                binding.likedCollectionCard.alpha = 1f
            }
        }
        viewModel.savedFoodsLiveData().observe(viewLifecycleOwner) { savedItems ->
            if (savedItems.isEmpty()) {
                binding.savedCollectionCount.text = getString(R.string.home_saved_empty)
                binding.savedCollectionCard.alpha = 0.8f
            } else {
                binding.savedCollectionCount.text = resources.getQuantityString(
                    R.plurals.collection_result_count,
                    savedItems.size,
                    savedItems.size
                )
                binding.savedCollectionCard.alpha = 1f
            }
        }
    }

    private fun observeSearchResults() {
        viewModel.searchResultsLiveData.observe(viewLifecycleOwner) { results ->
            val query = viewModel.searchQueryValue()
            val hasQuery = query.isNotBlank()
            binding.searchResultsContainer.isVisible = hasQuery
            binding.categoriesContainer.isVisible = !hasQuery
            if (hasQuery) {
                searchAdapter.submitList(results)
                binding.searchResultsCount.text = resources.getQuantityString(
                    R.plurals.search_result_count,
                    results.size,
                    results.size
                )
                binding.searchResultsEmpty.isVisible = results.isEmpty()
                binding.searchResultsRecyclerView.isVisible = results.isNotEmpty()
            } else {
                searchAdapter.submitList(emptyList())
            }
        }
    }

    private fun handleCategorySelection(category: CategorySummary) {
        hideKeyboard()
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

    private fun hideKeyboard() {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(binding.searchEditText.windowToken, 0)
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
