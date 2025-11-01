package com.amirreza.restaurantapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.amirreza.restaurantapp.data.model.Food

/**
 * Data Access Object for Food entity
 * Following Repository pattern and Single Responsibility Principle
 */
@Dao
interface FoodDao {
    
    // Basic CRUD operations
    @Query("SELECT * FROM food_table ORDER BY name ASC")
    fun getAllFoods(): LiveData<List<Food>>
    
    @Query("SELECT * FROM food_table WHERE id = :id")
    suspend fun getFoodById(id: Long): Food?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFoods(foods: List<Food>)
    
    @Update
    suspend fun updateFood(food: Food)
    
    @Delete
    suspend fun deleteFood(food: Food)
    
    // Category-based queries
    @Query("SELECT DISTINCT category1 FROM food_table WHERE is_available = 1")
    suspend fun getAllMainCategories(): List<String>
    
    @Query("SELECT DISTINCT category2 FROM food_table WHERE category1 = :mainCategory AND category2 IS NOT NULL AND is_available = 1")
    suspend fun getSubCategories(mainCategory: String): List<String>
    
    @Query("SELECT * FROM food_table WHERE category1 = :category AND category2 IS NULL AND is_available = 1 ORDER BY name ASC")
    fun getFoodsByMainCategory(category: String): LiveData<List<Food>>
    
    @Query("SELECT * FROM food_table WHERE category1 = :mainCategory AND category2 = :subCategory AND is_available = 1 ORDER BY name ASC")
    fun getFoodsBySubCategory(mainCategory: String, subCategory: String): LiveData<List<Food>>
    
    // Search functionality (Extra feature)
    @Query("SELECT * FROM food_table WHERE name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' AND is_available = 1")
    fun searchFoods(query: String): LiveData<List<Food>>
    
    // Favorites functionality (Extra feature)
    @Query("SELECT * FROM food_table WHERE is_favorite = 1 ORDER BY name ASC")
    fun getFavoriteFoods(): LiveData<List<Food>>
    
    @Query("UPDATE food_table SET is_favorite = :isFavorite WHERE id = :foodId")
    suspend fun updateFavoriteStatus(foodId: Long, isFavorite: Boolean)
    
    // Rating functionality (Extra feature)
    @Query("UPDATE food_table SET rating = :rating WHERE id = :foodId")
    suspend fun updateRating(foodId: Long, rating: Float)
    
    // Top rated foods (Extra feature)
    @Query("SELECT * FROM food_table WHERE rating >= 4.0 AND is_available = 1 ORDER BY rating DESC LIMIT 10")
    fun getTopRatedFoods(): LiveData<List<Food>>
    
    // Category count for UI (Extra feature)
    @Query("SELECT COUNT(*) FROM food_table WHERE category1 = :category AND is_available = 1")
    suspend fun getCategoryCount(category: String): Int
}