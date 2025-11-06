package com.ramin.restaurantapp.ui.common

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramin.restaurantapp.databinding.ItemFoodBinding
import com.ramin.restaurantapp.model.FoodItem

class FoodAdapter(
    private val onItemSelected: (FoodItem) -> Unit,
    private val badgeProvider: ((FoodItem) -> FoodBadge)? = null,
) : ListAdapter<FoodItem, FoodAdapter.FoodViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodItem) {
            binding.foodTitle.text = item.name
            binding.foodDescription.text = item.description
            binding.foodCategoryChip.text = item.subcategory?.takeIf { it.isNotBlank() } ?: item.category
            if (item.imageUrl.isNotBlank()) {
                Glide.with(binding.foodImage.context)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(binding.foodImage)
            }
            val badge = badgeProvider?.invoke(item)
            if (badge != null) {
                binding.foodBadge.isVisible = true
                binding.foodBadge.setImageResource(badge.iconRes)
                binding.foodBadge.contentDescription = badge.contentDescription
                binding.foodBadge.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(binding.root.context, badge.iconTint)
                )
                binding.foodBadge.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(binding.root.context, badge.backgroundTint)
                )
            } else {
                binding.foodBadge.isVisible = false
            }
            binding.root.setOnClickListener { onItemSelected(item) }
        }
    }

    data class FoodBadge(
        val iconRes: Int,
        val backgroundTint: Int,
        val iconTint: Int,
        val contentDescription: String,
    )

    private object DiffCallback : DiffUtil.ItemCallback<FoodItem>() {
        override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean =
            oldItem == newItem
    }
}
