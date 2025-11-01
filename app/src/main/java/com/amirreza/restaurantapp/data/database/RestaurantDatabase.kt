package com.amirreza.restaurantapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amirreza.restaurantapp.data.dao.FoodDao
import com.amirreza.restaurantapp.data.model.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Room Database class following Singleton pattern
 * Implements database creation and population with sample data
 */
@Database(
    entities = [Food::class],
    version = 1,
    exportSchema = false
)
abstract class RestaurantDatabase : RoomDatabase() {
    
    abstract fun foodDao(): FoodDao
    
    companion object {
        @Volatile
        private var INSTANCE: RestaurantDatabase? = null
        
        fun getDatabase(context: Context): RestaurantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantDatabase::class.java,
                    "restaurant_database"
                )
                .addCallback(DatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        /**
         * Database callback to populate with sample data
         */
        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        populateDatabase(database.foodDao())
                    }
                }
            }
        }
        
        /**
         * Populate database with sample Persian/Iranian restaurant data
         */
        private suspend fun populateDatabase(foodDao: FoodDao) {
            val sampleFoods = listOf(
                // فست فود (Fast Food)
                Food(
                    name = "پیتزا مخصوص",
                    category1 = "فست فود",
                    category2 = "پیتزا",
                    description = "پیتزا مخصوص با گوشت، قارچ، فلفل دلمه و پنیر موزارلا",
                    imageUrls = "[\"https://example.com/pizza1.jpg\", \"https://example.com/pizza2.jpg\"]",
                    videoUrls = "[\"https://example.com/pizza_video.mp4\"]",
                    price = 250000.0,
                    rating = 4.5f,
                    ingredients = "گوشت چرخ کرده، قارچ، فلفل دلمه، پنیر موزارلا، خمیر پیتزا",
                    calories = 350,
                    preparationTime = 25
                ),
                Food(
                    name = "ساندویچ کباب کوبیده",
                    category1 = "فست فود",
                    category2 = "ساندویچ",
                    description = "ساندویچ کباب کوبیده با سبزیجات تازه و سس مخصوص",
                    imageUrls = "[\"https://example.com/sandwich1.jpg\"]",
                    price = 180000.0,
                    rating = 4.2f,
                    preparationTime = 15
                ),
                
                // کباب (Kebab)
                Food(
                    name = "کباب کوبیده",
                    category1 = "کباب",
                    category2 = null,
                    description = "کباب کوبیده دو سیخ با برنج و سبزی",
                    imageUrls = "[\"https://example.com/kobide1.jpg\", \"https://example.com/kobide2.jpg\"]",
                    price = 320000.0,
                    rating = 4.8f,
                    preparationTime = 20
                ),
                Food(
                    name = "کباب برگ",
                    category1 = "کباب",
                    category2 = null,
                    description = "کباب برگ گوسفندی با برنج زعفرانی",
                    imageUrls = "[\"https://example.com/barg1.jpg\"]",
                    price = 450000.0,
                    rating = 4.9f,
                    preparationTime = 25
                ),
                
                // ایرانی (Iranian)
                Food(
                    name = "لوبیا پلو",
                    category1 = "ایرانی",
                    category2 = null,
                    description = "لوبیا پلو با گوشت و برنج عنبربو",
                    imageUrls = "[\"https://example.com/loobia1.jpg\"]",
                    price = 280000.0,
                    rating = 4.4f,
                    preparationTime = 30
                ),
                Food(
                    name = "کشک بادمجان",
                    category1 = "ایرانی",
                    category2 = null,
                    description = "کشک بادمجان با گردو و نعنا",
                    imageUrls = "[\"https://example.com/kashk1.jpg\"]",
                    price = 150000.0,
                    rating = 4.3f,
                    preparationTime = 20
                ),
                
                // سالاد (Salad)
                Food(
                    name = "سالاد سزار",
                    category1 = "سالاد",
                    category2 = null,
                    description = "سالاد سزار با مرغ گریل و پنیر پارمزان",
                    imageUrls = "[\"https://example.com/caesar1.jpg\"]",
                    price = 200000.0,
                    rating = 4.1f,
                    calories = 180,
                    preparationTime = 10
                ),
                
                // نوشیدنی (Drinks)
                Food(
                    name = "چای سنتی",
                    category1 = "نوشیدنی",
                    category2 = "گرم",
                    description = "چای سنتی ایرانی با شکر یا نبات",
                    imageUrls = "[\"https://example.com/tea1.jpg\"]",
                    price = 25000.0,
                    rating = 4.0f,
                    preparationTime = 5
                ),
                Food(
                    name = "آبمیوه طبیعی",
                    category1 = "نوشیدنی",
                    category2 = "سرد",
                    description = "آبمیوه طبیعی پرتقال تازه",
                    imageUrls = "[\"https://example.com/juice1.jpg\"]",
                    price = 45000.0,
                    rating = 4.2f,
                    calories = 120,
                    preparationTime = 3
                )
            )
            
            foodDao.insertAllFoods(sampleFoods)
        }
    }
}