package com.example.task5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task5.diffUtils.ItemDiffCallback
import com.example.task5.extensions.Glide
import com.example.task5.data.ItemModel
import com.example.task5.databinding.SingleField1Binding
import com.example.task5.databinding.SingleField2Binding
import com.example.task5.databinding.SingleField3Binding

class ItemAdapter : ListAdapter<ItemModel, RecyclerView.ViewHolder>(ItemDiffCallback()) {

//    var itemClick: ((ItemModel.List.NestedList) -> Unit)? = null

    private lateinit var mListener: OnItemClickListener
    private lateinit var mListener2: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: ItemModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun setOnItemClickListener2(listener2: OnItemClickListener) {
        mListener2 = listener2
    }

    companion object {
        const val INPUT = 1
        const val CHOOSER_DATE = 2
        const val CHOOSER_GENDER = 3
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            INPUT -> FirstItemViewHolder(SingleField1Binding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
            CHOOSER_DATE -> SecondItemViewHolder(SingleField2Binding.inflate(LayoutInflater.from(
                parent.context), parent, false), mListener)
            else -> ThirdItemViewHolder(SingleField3Binding.inflate(LayoutInflater.from(parent.context),
                parent,
                false), mListener2)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is FirstItemViewHolder -> {
                holder.bind()
            }
            is SecondItemViewHolder -> {
                holder.bind()
            }
            is ThirdItemViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        val field = getItem(position)
        if (field.fieldType == "chooser" && field.hint == "Gender") {
            return CHOOSER_GENDER
        } else if (field.fieldType == "chooser" && field.hint == "Birthday") {
            return CHOOSER_DATE
        } else (field.fieldType == "input")
        return INPUT
    }

    inner class FirstItemViewHolder(private val binding: SingleField1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.tvField.hint = item.hint
            Glide().setImage(item.icon, binding.imgIcon)
        }
    }

    inner class SecondItemViewHolder(
        private val binding: SingleField2Binding,
        listener: OnItemClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.tvField.text = item.hint
            Glide().setImage(item.icon, binding.imgIcon)
//            itemView.setOnClickListener {
//                itemClick?.invoke(item)
//            }
            itemView.setOnClickListener {
                mListener.onItemClick(item)
            }
        }
    }

    inner class ThirdItemViewHolder(
        private val binding: SingleField3Binding,
        listener: OnItemClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item2 = currentList[adapterPosition]
            binding.tvField.text = item2.hint
            Glide().setImage(item2.icon, binding.imgIcon)
            itemView.setOnClickListener {
                mListener2.onItemClick(item2)
            }
        }
    }
}
