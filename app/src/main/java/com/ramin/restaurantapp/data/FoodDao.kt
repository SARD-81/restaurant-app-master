package com.ramin.restaurantapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM food ORDER BY name")
    fun getAllFoods(): Flow<List<FoodEntity>>

    @Query("SELECT DISTINCT category_1 FROM food ORDER BY category_1")
    fun getLevelOneCategories(): Flow<List<String>>

    @Query("SELECT DISTINCT category_2 FROM food WHERE category_1 = :category AND category_2 IS NOT NULL AND category_2 != '' ORDER BY category_2")
    fun getSubcategoriesFor(category: String): Flow<List<String>>

    @Query("SELECT * FROM food WHERE category_1 = :category AND (category_2 IS NULL OR category_2 = '') ORDER BY name")
    fun getFoodsForCategory(category: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM food WHERE category_1 = :category AND category_2 = :subcategory ORDER BY name")
    fun getFoodsForSubcategory(category: String, subcategory: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM food WHERE id = :id")
    fun getFoodById(id: Int): Flow<FoodEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<FoodEntity>)

    @Query("DELETE FROM food")
    fun clear()
}
