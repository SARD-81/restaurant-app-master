package com.amirreza.restaurantapp.data.repository

import androidx.lifecycle.LiveData
import com.amirreza.restaurantapp.data.dao.FoodDao
import com.amirreza.restaurantapp.data.model.Category
import com.amirreza.restaurantapp.data.model.Food

/**
 * Repository class implementing Repository pattern
 * Follows Single Responsibility Principle - handles data operations
 * Abstracts data sources from ViewModels (SOC)
 */
class RestaurantRepository(private val foodDao: FoodDao) {
    
    // Food operations
    fun getAllFoods(): LiveData<List<Food>> = foodDao.getAllFoods()
    
    suspend fun getFoodById(id: Long): Food? = foodDao.getFoodById(id)
    
    suspend fun insertFood(food: Food): Long = foodDao.insertFood(food)
    
    suspend fun updateFood(food: Food) = foodDao.updateFood(food)
    
    suspend fun deleteFood(food: Food) = foodDao.deleteFood(food)
    
    // Category operations
    suspend fun getMainCategories(): List<Category> {
        val categories = foodDao.getAllMainCategories()
        return categories.map { categoryName ->
            val count = foodDao.getCategoryCount(categoryName)
            Category(
                name = categoryName,
                imageUrl = getCategoryImageUrl(categoryName),
                itemCount = count
            )
        }
    }
    
    suspend fun getSubCategories(mainCategory: String): List<Category> {
        val subCategories = foodDao.getSubCategories(mainCategory)
        return subCategories.map { subCategoryName ->
            Category(
                name = subCategoryName,
                imageUrl = getSubCategoryImageUrl(mainCategory, subCategoryName),
                isSubCategory = true,
                parentCategory = mainCategory
            )
        }
    }
    
    fun getFoodsByMainCategory(category: String): LiveData<List<Food>> =
        foodDao.getFoodsByMainCategory(category)
    
    fun getFoodsBySubCategory(mainCategory: String, subCategory: String): LiveData<List<Food>> =
        foodDao.getFoodsBySubCategory(mainCategory, subCategory)
    
    // Search functionality (Extra feature)
    fun searchFoods(query: String): LiveData<List<Food>> = foodDao.searchFoods(query)
    
    // Favorites functionality (Extra feature)
    fun getFavoriteFoods(): LiveData<List<Food>> = foodDao.getFavoriteFoods()
    
    suspend fun updateFavoriteStatus(foodId: Long, isFavorite: Boolean) =
        foodDao.updateFavoriteStatus(foodId, isFavorite)
    
    // Rating functionality (Extra feature)
    suspend fun updateRating(foodId: Long, rating: Float) =
        foodDao.updateRating(foodId, rating)
    
    fun getTopRatedFoods(): LiveData<List<Food>> = foodDao.getTopRatedFoods()
    
    /**
     * Helper function to get category image URLs
     * Following DRY principle - centralized image URL logic
     */
    private fun getCategoryImageUrl(category: String): String {
        return when (category) {
            "فست فود" -> "https://example.com/category_fastfood.jpg"
            "کباب" -> "https://example.com/category_kebab.jpg"
            "ایرانی" -> "https://example.com/category_iranian.jpg"
            "سالاد" -> "https://example.com/category_salad.jpg"
            "نوشیدنی" -> "https://example.com/category_drinks.jpg"
            else -> "https://example.com/category_default.jpg"
        }
    }
    
    private fun getSubCategoryImageUrl(mainCategory: String, subCategory: String): String {
        return when ("$mainCategory-$subCategory") {
            "فست فود-پیتزا" -> "https://example.com/subcategory_pizza.jpg"
            "فست فود-ساندویچ" -> "https://example.com/subcategory_sandwich.jpg"
            "نوشیدنی-گرم" -> "https://example.com/subcategory_hot_drinks.jpg"
            "نوشیدنی-سرد" -> "https://example.com/subcategory_cold_drinks.jpg"
            else -> "https://example.com/subcategory_default.jpg"
        }
    }
}