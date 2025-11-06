package com.ramin.restaurantapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.ramin.restaurantapp.data.RestaurantPreferences
import com.ramin.restaurantapp.data.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class RestaurantViewModel(
    private val repository: RestaurantRepository,
    private val preferences: RestaurantPreferences,
) : ViewModel() {

    fun categoriesLiveData() = repository.observeCategories().asLiveData()

    fun subcategoriesLiveData(category: String) = repository.observeSubcategories(category).asLiveData()

    fun foodsLiveData(category: String, subcategory: String?) = repository.observeFoods(category, subcategory).asLiveData()

    fun foodDetailLiveData(id: Int) = repository.observeFoodDetail(id).asLiveData()

    fun fullMenuLiveData() = repository.observeAllFoods().asLiveData()

    val likedIdsLiveData = preferences.likedIds.asLiveData()

    val savedIdsLiveData = preferences.savedIds.asLiveData()

    fun likedFoodsLiveData() = preferences.likedIds
        .flatMapLatest { ids -> repository.observeFoodsByIds(ids) }
        .asLiveData()

    fun savedFoodsLiveData() = preferences.savedIds
        .flatMapLatest { ids -> repository.observeFoodsByIds(ids) }
        .asLiveData()

    fun toggleLiked(id: Int) {
        preferences.toggleLiked(id)
    }

    fun toggleSaved(id: Int) {
        preferences.toggleSaved(id)
    }

    fun isLiked(id: Int): Boolean = preferences.isLiked(id)

    fun isSaved(id: Int): Boolean = preferences.isSaved(id)

    private val searchQuery = MutableStateFlow("")

    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    fun searchQueryValue(): String = searchQuery.value

    val searchResultsLiveData = searchQuery
        .debounce(300)
        .map { it.trim() }
        .distinctUntilChanged()
        .flatMapLatest { query ->
            if (query.isBlank()) {
                flowOf(emptyList())
            } else {
                repository.searchFoods(query)
            }
        }
        .asLiveData()

    class Factory(
        private val repository: RestaurantRepository,
        private val preferences: RestaurantPreferences,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
                return RestaurantViewModel(repository, preferences) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
