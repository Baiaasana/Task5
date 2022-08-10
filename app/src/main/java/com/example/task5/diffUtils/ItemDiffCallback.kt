package com.example.task5.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.task5.data.ItemModel

class ItemDiffCallback : DiffUtil.ItemCallback<ItemModel>() {
    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem.fieldId == newItem.fieldId
    }

    override fun areContentsTheSame(
        oldItem: ItemModel,
        newItem: ItemModel,
    ): Boolean {
        return oldItem == newItem
    }

}