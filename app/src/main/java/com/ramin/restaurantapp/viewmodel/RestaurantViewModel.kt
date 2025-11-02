package com.ramin.restaurantapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.ramin.restaurantapp.data.RestaurantRepository

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    fun categoriesLiveData() = repository.observeCategories().asLiveData()

    fun subcategoriesLiveData(category: String) = repository.observeSubcategories(category).asLiveData()

    fun foodsLiveData(category: String, subcategory: String?) = repository.observeFoods(category, subcategory).asLiveData()

    fun foodDetailLiveData(id: Int) = repository.observeFoodDetail(id).asLiveData()

    class Factory(private val repository: RestaurantRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
                return RestaurantViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
