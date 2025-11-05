package com.ramin.restaurantapp.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramin.restaurantapp.databinding.ItemFoodBinding
import com.ramin.restaurantapp.model.FoodItem

class FoodAdapter(
    private val onItemSelected: (FoodItem) -> Unit
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
            binding.foodCategoryChip.text = item.subcategory ?: item.category
            if (item.imageUrl.isNotBlank()) {
                Glide.with(binding.foodImage.context)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(binding.foodImage)
            }
            binding.root.setOnClickListener { onItemSelected(item) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<FoodItem>() {
        override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean =
            oldItem == newItem
    }
}
