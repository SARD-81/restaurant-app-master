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
                    hasSubcategories = items.any { !it.categoryLevel2.isNullOrBlank() }
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
            entities.map { entity ->
                FoodItem(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description,
                    imageUrl = entity.imageList().firstOrNull().orEmpty(),
                    category = entity.categoryLevel1,
                    subcategory = entity.categoryLevel2
                )
            }
        }
    }

    fun observeFoodDetail(id: Int): Flow<FoodItem> {
        return foodDao.getFoodById(id).map { entity ->
            FoodItem(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                imageUrl = entity.imageList().firstOrNull().orEmpty(),
                category = entity.categoryLevel1,
                subcategory = entity.categoryLevel2,
                media = buildMedia(entity)
            )
        }
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
