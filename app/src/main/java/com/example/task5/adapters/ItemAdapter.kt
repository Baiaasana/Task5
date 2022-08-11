package com.example.task5.adapters

import android.app.DatePickerDialog
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

import java.util.*

class ItemAdapter : ListAdapter<ItemModel, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    var itemClick: ((ItemModel) -> Unit)? = null

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
                parent.context), parent, false), parent)
            else -> ThirdItemViewHolder(SingleField3Binding.inflate(LayoutInflater.from(parent.context),
                parent,
                false), parent)
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
        private val binding: SingleField2Binding, val parent: ViewGroup,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.tvField.hint = item.hint
            Glide().setImage(item.icon, binding.imgIcon)
            binding.imgIcon.setOnClickListener {
//               itemClick?.invoke(item)
                datePicker()
            }
        }

        private fun datePicker() {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val popup = DatePickerDialog(parent.context, { view, year, monthOfYear, dayOfMonth ->
                binding.tvField.setText("$dayOfMonth/$monthOfYear/$year")
            }, year, month, day)
            popup.show()
        }
    }

    inner class ThirdItemViewHolder(
        private val binding: SingleField3Binding, parent: ViewGroup,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]
            binding.tvField.hint = item.hint
            Glide().setImage(item.icon, binding.imgIcon)
            binding.imgIcon.setOnClickListener {
                itemClick?.invoke(item)

            }
        }
    }
}

