package com.example.task5.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task5.DatePickerFragment
import com.example.task5.adapters.ItemAdapter
import com.example.task5.data.ItemModel
import com.example.task5.data.list
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
            itemAdapter.submitList(list)
        }
    }

    private fun listeners() {

        binding.btnRegister.setOnClickListener {
            //checks
        }

        itemAdapter.setOnItemClickListener(object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: ItemModel.List.NestedList) {

                // create new instance of DatePickerFragment
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                // we have to implement setFragmentResultListener
                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        position.hint = date.toString()
                        list.get(4).hint = date.toString()
                        itemAdapter.submitList(list.toList())
                    }
                }
                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        })

        itemAdapter.setOnItemClickListener2(object : ItemAdapter.OnItemClickListener{
            override fun onItemClick(position: ItemModel.List.NestedList) {

                findNavController().navigate(InfoFragmentDirections.actionInfoFragmentToStartFragment())

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
