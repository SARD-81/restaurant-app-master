package com.ramin.restaurantapp.data

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantPreferences(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _likedIds = MutableStateFlow(loadIds(KEY_LIKED_IDS))
    private val _savedIds = MutableStateFlow(loadIds(KEY_SAVED_IDS))

    val likedIds: StateFlow<Set<Int>> = _likedIds.asStateFlow()
    val savedIds: StateFlow<Set<Int>> = _savedIds.asStateFlow()

    fun isLiked(id: Int): Boolean = _likedIds.value.contains(id)

    fun isSaved(id: Int): Boolean = _savedIds.value.contains(id)

    fun toggleLiked(id: Int) {
        updateCollection(id, _likedIds, KEY_LIKED_IDS)
    }

    fun toggleSaved(id: Int) {
        updateCollection(id, _savedIds, KEY_SAVED_IDS)
    }

    private fun updateCollection(
        id: Int,
        flow: MutableStateFlow<Set<Int>>,
        key: String,
    ) {
        val mutable = flow.value.toMutableSet()
        if (!mutable.add(id)) {
            mutable.remove(id)
        }
        flow.value = mutable
        persistIds(key, mutable)
    }

    private fun loadIds(key: String): Set<Int> {
        return sharedPreferences.getStringSet(key, emptySet())
            ?.mapNotNull { it.toIntOrNull() }
            ?.toSet()
            ?: emptySet()
    }

    private fun persistIds(key: String, ids: Set<Int>) {
        sharedPreferences.edit()
            .putStringSet(key, ids.map { it.toString() }.toSet())
            .apply()
    }

    companion object {
        private const val PREFS_NAME = "restaurant_user_state"
        private const val KEY_LIKED_IDS = "liked_food_ids"
        private const val KEY_SAVED_IDS = "saved_food_ids"
    }
}
