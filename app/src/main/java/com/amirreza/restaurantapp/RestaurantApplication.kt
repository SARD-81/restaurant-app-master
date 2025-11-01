package com.amirreza.restaurantapp

import android.app.Application
import com.amirreza.restaurantapp.data.database.RestaurantDatabase
import com.amirreza.restaurantapp.data.repository.RestaurantRepository

/**
 * Application class following Single Responsibility Principle
 * Initializes database and repository for dependency injection
 */
class RestaurantApplication : Application() {
    
    // Database instance (lazy initialization)
    val database by lazy { RestaurantDatabase.getDatabase(this) }
    
    // Repository instance (lazy initialization)
    val repository by lazy { RestaurantRepository(database.foodDao()) }
    
    override fun onCreate() {
        super.onCreate()
        // Initialize any global configurations here
    }
}