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
 * Category ViewModel for handling category screens
 * Shows subcategories or food items based on category structure
 */
class CategoryViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: RestaurantRepository = 
        (application as RestaurantApplication).repository
    
    // Current category info
    private val _currentCategory = MutableLiveData<String>()
    val currentCategory: LiveData<String> = _currentCategory
    
    // Subcategories (if any)
    private val _subCategories = MutableLiveData<List<Category>>()
    val subCategories: LiveData<List<Category>> = _subCategories
    
    // Food items
    private val _foods = MutableLiveData<List<Food>>()
    val foods: LiveData<List<Food>> = _foods
    
    // UI states
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    private val _hasSubCategories = MutableLiveData<Boolean>()
    val hasSubCategories: LiveData<Boolean> = _hasSubCategories
    
    /**
     * Load category content (subcategories or foods)
     */
    fun loadCategory(categoryName: String) {
        _currentCategory.value = categoryName
        
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                // Check if category has subcategories
                val subCategoriesList = repository.getSubCategories(categoryName)
                
                if (subCategoriesList.isNotEmpty()) {
                    // Show subcategories
                    _subCategories.value = subCategoriesList
                    _hasSubCategories.value = true
                    _foods.value = emptyList()
                } else {
                    // Show food items directly
                    repository.getFoodsByMainCategory(categoryName).observeForever { foodList ->
                        _foods.value = foodList
                    }
                    _hasSubCategories.value = false
                    _subCategories.value = emptyList()
                }
                
            } catch (e: Exception) {
                _error.value = "خطا در بارگذاری دسته‌بندی: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Load foods from subcategory
     */
    fun loadSubCategory(mainCategory: String, subCategory: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                repository.getFoodsBySubCategory(mainCategory, subCategory).observeForever { foodList ->
                    _foods.value = foodList
                }
                _hasSubCategories.value = false
                
            } catch (e: Exception) {
                _error.value = "خطا در بارگذاری زیردسته: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}