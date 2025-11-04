package com.ramin.restaurantapp.model

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val category: String,
    val subcategory: String?,
    val media: List<FoodMedia> = emptyList()
)
