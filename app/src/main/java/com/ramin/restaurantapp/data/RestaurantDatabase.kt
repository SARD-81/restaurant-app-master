package com.ramin.restaurantapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [FoodEntity::class], version = 5, exportSchema = false)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: RestaurantDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): RestaurantDatabase {
            val instance = INSTANCE ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantDatabase::class.java,
                    "restaurant_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = newInstance
                newInstance
            }
            scope.launch(Dispatchers.IO) {
                seedDatabase(instance.foodDao())
            }
            return instance
        }

        private suspend fun seedDatabase(foodDao: FoodDao) {
            if (foodDao.getFoodCount() == 0) {
                foodDao.insertAll(SampleDataProvider.foodItems())
            }
        }
    }
}
