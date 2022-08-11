package com.example.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import com.example.task5.adapters.ItemAdapter
import com.example.task5.data.list
import com.example.task5.databinding.FragmentDialogBinding

class DialogFragment : DialogFragment() {

    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!
    private val itemAdapter: ItemAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val selectedId = binding.genderRadioGroup.checkedRadioButtonId
            val radio = binding.root.findViewById<RadioButton>(selectedId)
            list[5].hint = radio.text.toString()
            itemAdapter.submitList(list.toList())
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}