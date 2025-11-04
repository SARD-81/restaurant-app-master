package com.ramin.restaurantapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "category_1") val categoryLevel1: String,
    @ColumnInfo(name = "category_2") val categoryLevel2: String?,
    val description: String,
    @ColumnInfo(name = "image_urls") val imageUrls: String,
    @ColumnInfo(name = "video_urls") val videoUrls: String
) {
    fun imageList(): List<String> = imageUrls.split("|").filter { it.isNotBlank() }

    fun videoList(): List<String> = videoUrls.split("|").filter { it.isNotBlank() }
}
