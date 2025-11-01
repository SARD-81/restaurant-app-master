package com.amirreza.restaurantapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amirreza.restaurantapp.RestaurantApplication
import com.amirreza.restaurantapp.data.model.Food
import com.amirreza.restaurantapp.data.repository.RestaurantRepository
import kotlinx.coroutines.launch

/**
 * Food Detail ViewModel for individual food item screens
 * Handles favorite status, rating, and food details
 */
class FoodDetailViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: RestaurantRepository = 
        (application as RestaurantApplication).repository
    
    // Current food item
    private val _food = MutableLiveData<Food?>()
    val food: LiveData<Food?> = _food
    
    // UI states
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    // User interactions
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite
    
    private val _userRating = MutableLiveData<Float>()
    val userRating: LiveData<Float> = _userRating
    
    /**
     * Load food details by ID
     */
    fun loadFood(foodId: Long) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                val foodItem = repository.getFoodById(foodId)
                _food.value = foodItem
                _isFavorite.value = foodItem?.isFavorite ?: false
                _userRating.value = foodItem?.rating ?: 0f
                
            } catch (e: Exception) {
                _error.value = "خطا در بارگذاری جزئیات غذا: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Toggle favorite status (Extra feature)
     */
    fun toggleFavorite() {
        val currentFood = _food.value ?: return
        val newFavoriteStatus = !_isFavorite.value!!
        
        viewModelScope.launch {
            try {
                repository.updateFavoriteStatus(currentFood.id, newFavoriteStatus)
                _isFavorite.value = newFavoriteStatus
                
                // Update food object
                _food.value = currentFood.copy(isFavorite = newFavoriteStatus)
                
            } catch (e: Exception) {
                _error.value = "خطا در تغییر وضعیت علاقه‌مندی: ${e.message}"
            }
        }
    }
    
    /**
     * Update food rating (Extra feature)
     */
    fun updateRating(rating: Float) {
        val currentFood = _food.value ?: return
        
        viewModelScope.launch {
            try {
                repository.updateRating(currentFood.id, rating)
                _userRating.value = rating
                
                // Update food object
                _food.value = currentFood.copy(rating = rating)
                
            } catch (e: Exception) {
                _error.value = "خطا در ثبت امتیاز: ${e.message}"
            }
        }
    }
    
    /**
     * Parse image URLs from JSON string
     */
    fun getImageUrls(): List<String> {
        val food = _food.value ?: return emptyList()
        return try {
            // Simple JSON parsing - in production use Gson/Moshi
            food.imageUrls
                .removePrefix("[")
                .removeSuffix("]")
                .split(",")
                .map { it.trim().removeSurrounding("\"") }
                .filter { it.isNotEmpty() }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    /**
     * Parse video URLs from JSON string
     */
    fun getVideoUrls(): List<String> {
        val food = _food.value ?: return emptyList()
        val videoUrls = food.videoUrls ?: return emptyList()
        
        return try {
            videoUrls
                .removePrefix("[")
                .removeSuffix("]")
                .split(",")
                .map { it.trim().removeSurrounding("\"") }
                .filter { it.isNotEmpty() }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}