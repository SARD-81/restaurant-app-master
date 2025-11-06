package com.ramin.restaurantapp.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.databinding.ItemCategoryBinding
import com.ramin.restaurantapp.model.SubcategorySummary

class SubcategoryAdapter(
    private val onItemSelected: (SubcategorySummary) -> Unit
) : ListAdapter<SubcategorySummary, SubcategoryAdapter.SubcategoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubcategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SubcategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SubcategorySummary) {
            binding.categoryTitle.text = item.name
//            binding.categorySubtitle.text = binding.root.context.resources.getQuantityString(
//                R.plurals.category_item_count,
//                item.itemCount,
//                item.itemCount
//            )
            if (item.imageUrl.isNotBlank()) {
                Glide.with(binding.categoryImage.context)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(binding.categoryImage)
            }
            binding.root.setOnClickListener { onItemSelected(item) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<SubcategorySummary>() {
        override fun areItemsTheSame(oldItem: SubcategorySummary, newItem: SubcategorySummary): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: SubcategorySummary, newItem: SubcategorySummary): Boolean =
            oldItem == newItem
    }
}
