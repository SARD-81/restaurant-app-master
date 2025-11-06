package com.ramin.restaurantapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(entities = [FoodEntity::class], version = 2, exportSchema = false)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: RestaurantDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): RestaurantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantDatabase::class.java,
                    "restaurant_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(RestaurantDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class RestaurantDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.foodDao())
                }
            }
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    ensureSeedData(database.foodDao())
                }
            }
        }

        private suspend fun populateDatabase(foodDao: FoodDao) {
            withContext(Dispatchers.IO) {
                foodDao.clear()
                foodDao.insertAll(SampleDataProvider.foodItems())
            }
        }

        private suspend fun ensureSeedData(foodDao: FoodDao) {
            withContext(Dispatchers.IO) {
                if (foodDao.countFoods() == 0) {
                    foodDao.insertAll(SampleDataProvider.foodItems())
                }
            }
        }
    }
}
