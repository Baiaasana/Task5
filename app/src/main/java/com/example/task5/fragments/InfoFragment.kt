package com.example.task5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task5.adapters.ItemAdapter
import com.example.task5.data.list
import com.example.task5.databinding.FragmentInfoBinding

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

        //Gender chooser
        itemAdapter.itemClick = {
            findNavController().navigate(InfoFragmentDirections.actionInfoFragmentToDialogFragment())
            itemAdapter.submitList(list.toList())
        }

    }

    private fun saveInfoInMap() {
        TODO()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
