package com.amirreza.restaurantapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Food entity for Room database
 * Following the project requirements: name, category1, category2, description, image, video
 */
@Entity(tableName = "food_table")
@Parcelize
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "name")
    val name: String,
    
    @ColumnInfo(name = "category1")
    val category1: String, // Main category (فست فود، کباب، ایرانی، etc.)
    
    @ColumnInfo(name = "category2")
    val category2: String?, // Sub-category (پیتزا، ساندویچ، etc.) - nullable for direct items
    
    @ColumnInfo(name = "description")
    val description: String,
    
    @ColumnInfo(name = "image_urls")
    val imageUrls: String, // JSON string of image URLs
    
    @ColumnInfo(name = "video_urls")
    val videoUrls: String?, // JSON string of video URLs - nullable
    
    @ColumnInfo(name = "price")
    val price: Double = 0.0, // Extra feature: pricing
    
    @ColumnInfo(name = "rating")
    val rating: Float = 0.0f, // Extra feature: rating system
    
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false, // Extra feature: favorites
    
    @ColumnInfo(name = "ingredients")
    val ingredients: String? = null, // Extra feature: ingredients list
    
    @ColumnInfo(name = "calories")
    val calories: Int? = null, // Extra feature: nutritional info
    
    @ColumnInfo(name = "preparation_time")
    val preparationTime: Int? = null, // Extra feature: prep time in minutes
    
    @ColumnInfo(name = "is_available")
    val isAvailable: Boolean = true // Extra feature: availability status
) : Parcelable