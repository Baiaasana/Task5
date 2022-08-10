package com.example.task5.fragments

import androidx.lifecycle.ViewModel
import com.example.task5.data.ItemModel
import com.example.task5.retrofit.LatestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InfoViewModel : ViewModel() {

    private val _infoState = MutableStateFlow<LatestState<List<ItemModel>>>(LatestState.Success(
        emptyList()))
    val infoState = _infoState.asStateFlow()

    fun getInfo() {

        TODO()
    }

}