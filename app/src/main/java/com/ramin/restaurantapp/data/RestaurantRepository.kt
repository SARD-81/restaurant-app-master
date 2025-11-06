package com.ramin.restaurantapp.data

import com.ramin.restaurantapp.model.CategorySummary
import com.ramin.restaurantapp.model.FoodItem
import com.ramin.restaurantapp.model.FoodMedia
import com.ramin.restaurantapp.model.SubcategorySummary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class RestaurantRepository(private val foodDao: FoodDao) {

    fun observeCategories(): Flow<List<CategorySummary>> {
        return combine(
            foodDao.getAllFoods(),
            foodDao.getLevelOneCategories()
        ) { foods, categories ->
            categories.map { category ->
                val items = foods.filter { it.categoryLevel1 == category }
                val firstItem = items.firstOrNull()
                CategorySummary(
                    name = category,
                    imageUrl = firstItem?.imageList()?.firstOrNull() ?: "",
                    hasSubcategories = items.any { !it.categoryLevel2.isNullOrBlank() },
                    itemCount = items.size
                )
            }
        }.distinctUntilChanged()
    }

    fun observeSubcategories(category: String): Flow<List<SubcategorySummary>> {
        return foodDao.getAllFoods().map { foods ->
            foods.filter { it.categoryLevel1 == category && !it.categoryLevel2.isNullOrBlank() }
                .groupBy { it.categoryLevel2.orEmpty() }
                .map { (subcategory, items) ->
                    SubcategorySummary(
                        name = subcategory,
                        imageUrl = items.firstOrNull()?.imageList()?.firstOrNull() ?: ""
                    )
                }
                .sortedBy { it.name }
        }.distinctUntilChanged()
    }

    fun observeFoods(category: String, subcategory: String?): Flow<List<FoodItem>> {
        val baseFlow = if (subcategory.isNullOrBlank()) {
            foodDao.getFoodsForCategory(category)
        } else {
            foodDao.getFoodsForSubcategory(category, subcategory)
        }
        return baseFlow.map { entities ->
            entities.map { entity -> entity.toFoodItem() }
        }
    }

    fun observeFoodDetail(id: Int): Flow<FoodItem> {
        return foodDao.getFoodById(id).map { entity ->
            entity.toFoodItem(includeMedia = true)
        }
    }

    fun observeAllFoods(): Flow<List<FoodItem>> {
        return foodDao.getFullMenu().map { entities ->
            entities.map { entity -> entity.toFoodItem() }
        }
    }

    fun searchFoods(query: String): Flow<List<FoodItem>> {
        return foodDao.searchFoods(query).map { entities ->
            entities.map { entity -> entity.toFoodItem() }
        }
    }

    private fun FoodEntity.toFoodItem(includeMedia: Boolean = false): FoodItem {
        return FoodItem(
            id = id,
            name = name,
            description = description,
            imageUrl = imageList().firstOrNull().orEmpty(),
            category = categoryLevel1,
            subcategory = categoryLevel2,
            media = if (includeMedia) buildMedia(this) else emptyList()
        )
    }

    private fun buildMedia(entity: FoodEntity): List<FoodMedia> {
        val images = entity.imageList().map { url ->
            FoodMedia.Image(url)
        }
        val videos = entity.videoList().map { url ->
            FoodMedia.Video(url)
        }
        return images + videos
    }
}
