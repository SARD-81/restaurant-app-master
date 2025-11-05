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
    @ColumnInfo(name = "photo") val photo: String,
    @ColumnInfo(name = "video") val video: String
) {
    fun imageList(): List<String> = photo.split("|").map { it.trim() }.filter { it.isNotEmpty() }

    fun videoList(): List<String> = video.split("|").map { it.trim() }.filter { it.isNotEmpty() }
}
