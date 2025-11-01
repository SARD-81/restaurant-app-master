package com.amirreza.restaurantapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amirreza.restaurantapp.RestaurantApplication
import com.amirreza.restaurantapp.data.model.Category
import com.amirreza.restaurantapp.data.model.Food
import com.amirreza.restaurantapp.data.repository.RestaurantRepository
import kotlinx.coroutines.launch

/**
 * Main ViewModel following MVVM pattern
 * Handles main screen categories and navigation logic
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: RestaurantRepository = 
        (application as RestaurantApplication).repository
    
    // LiveData for main categories
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories
    
    // Loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    // Error handling
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    // Search functionality (Extra feature)
    private val _searchResults = MutableLiveData<List<Food>>()
    val searchResults: LiveData<List<Food>> = _searchResults
    
    // Top rated foods (Extra feature)
    val topRatedFoods: LiveData<List<Food>> = repository.getTopRatedFoods()
    
    init {
        loadMainCategories()
    }
    
    /**
     * Load main categories from database
     * Following error handling best practices
     */
    private fun loadMainCategories() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                val categoriesList = repository.getMainCategories()
                _categories.value = categoriesList
            } catch (e: Exception) {
                _error.value = "خطا در بارگذاری دسته‌بندی‌ها: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Search foods by query (Extra feature)
     */
    fun searchFoods(query: String) {
        if (query.trim().isEmpty()) {
            _searchResults.value = emptyList()
            return
        }
        
        viewModelScope.launch {
            try {
                repository.searchFoods(query.trim()).observeForever { foods ->
                    _searchResults.value = foods
                }
            } catch (e: Exception) {
                _error.value = "خطا در جستجو: ${e.message}"
            }
        }
    }
    
    /**
     * Clear error message
     */
    fun clearError() {
        _error.value = null
    }
    
    /**
     * Refresh categories
     */
    fun refreshCategories() {
        loadMainCategories()
    }
}