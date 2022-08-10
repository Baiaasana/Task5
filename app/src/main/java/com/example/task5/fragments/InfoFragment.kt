package com.example.task5.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task5.DatePickerFragment
import com.example.task5.DialogFragment
import com.example.task5.adapters.ItemAdapter
import com.example.task5.data.ItemModel
import com.example.task5.data.list
import com.example.task5.data.mapOfUserInfo
import com.example.task5.databinding.FragmentInfoBinding
import com.example.task5.databinding.SingleField2Binding

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private var itemAdapter: ItemAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        listeners()

    }


    private fun init() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
            itemAdapter.submitList(list.toList())
        }
    }

    private fun listeners() {
        binding.btnRegister.setOnClickListener {
            //checks
            TODO()

        }

        // Date chooser
        itemAdapter.setOnItemClickListener(object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: ItemModel) {

                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        position.hint = date.toString()
//                        list[4].hint = date.toString()
                        itemAdapter.submitList(list.toList())
                    }
                }
                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        })

        //Gender chooser
        itemAdapter.setOnItemClickListener2(object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: ItemModel) {

                var dialog = DialogFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager
                dialog.show(supportFragmentManager, "dialog")
            }
        })
    }

    private fun saveInfoInMap() {
        TODO()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
