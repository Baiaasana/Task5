package com.example.task5.DiffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.task5.data.ItemModel

class ItemDiffCallback : DiffUtil.ItemCallback<ItemModel.List.NestedList>() {
    override fun areItemsTheSame(oldItem: ItemModel.List.NestedList, newItem: ItemModel.List.NestedList): Boolean {
        return oldItem.fieldId  == newItem.fieldId
    }

    override fun areContentsTheSame(
        oldItem: ItemModel.List.NestedList,
        newItem: ItemModel.List.NestedList,
    ): Boolean {
        return oldItem == newItem
    }

}