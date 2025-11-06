package com.ramin.restaurantapp

import android.app.Application
import com.ramin.restaurantapp.data.RestaurantDatabase
import com.ramin.restaurantapp.data.RestaurantPreferences
import com.ramin.restaurantapp.data.RestaurantRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RestaurantApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { RestaurantDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { RestaurantRepository(database.foodDao()) }
    val preferences by lazy { RestaurantPreferences(this) }
}
