package com.ramin.restaurantapp.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ramin.restaurantapp.databinding.ItemCategoryChipBinding
import com.ramin.restaurantapp.model.CategorySummary

class CategoryChipAdapter(
    private val onCategorySelected: (CategorySummary) -> Unit
) : ListAdapter<CategorySummary, CategoryChipAdapter.CategoryChipViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryChipViewHolder {
        val binding = ItemCategoryChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryChipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryChipViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryChipViewHolder(
        private val binding: ItemCategoryChipBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategorySummary) {
            binding.categoryChip.apply {
                text = item.name
                isChecked = false
                setOnClickListener { onCategorySelected(item) }
            }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<CategorySummary>() {
        override fun areItemsTheSame(oldItem: CategorySummary, newItem: CategorySummary): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: CategorySummary, newItem: CategorySummary): Boolean =
            oldItem == newItem
    }
}
