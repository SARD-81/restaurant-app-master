package com.ramin.restaurantapp.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.databinding.ItemCategoryBinding
import com.ramin.restaurantapp.model.CategorySummary

class CategoryAdapter(
    private val onCategorySelected: (CategorySummary) -> Unit
) : ListAdapter<CategorySummary, CategoryAdapter.CategoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategorySummary) {
            binding.categoryTitle.text = item.name
            val context = binding.root.context
            val subtitleRes = if (item.hasSubcategories) {
                R.string.category_subtitle_has_children
            } else {
                R.string.category_subtitle_no_children
            }
//            binding.categorySubtitle.text = context.getString(subtitleRes)
            binding.categoryCountChip.text = context.resources.getQuantityString(
                R.plurals.category_item_count,
                item.itemCount,
                item.itemCount
            )
            if (item.imageUrl.isNotBlank()) {
                Glide.with(binding.categoryImage.context)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(binding.categoryImage)
            }
            binding.root.setOnClickListener { onCategorySelected(item) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<CategorySummary>() {
        override fun areItemsTheSame(oldItem: CategorySummary, newItem: CategorySummary): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: CategorySummary, newItem: CategorySummary): Boolean =
            oldItem == newItem
    }
}
