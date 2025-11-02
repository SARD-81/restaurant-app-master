package com.ramin.restaurantapp.model

sealed class FoodMedia {
    data class Image(val url: String) : FoodMedia()
    data class Video(val url: String) : FoodMedia()
}
