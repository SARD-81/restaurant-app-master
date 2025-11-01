package com.amirreza.restaurantapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class for categories (following DRY principle)
 * Used for both main categories and subcategories
 */
@Parcelize
data class Category(
    val name: String,
    val imageUrl: String,
    val isSubCategory: Boolean = false,
    val parentCategory: String? = null,
    val itemCount: Int = 0 // Extra feature: show item count
) : Parcelable