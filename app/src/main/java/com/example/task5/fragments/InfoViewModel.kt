package com.example.task5.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task5.data.ItemModel
import com.example.task5.retrofit.LatestState
import com.example.task5.retrofit.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InfoViewModel: ViewModel() {

    private val _infoState = MutableStateFlow<LatestState<List<ItemModel>>>(LatestState.Success(
        emptyList()))
    val infoState = _infoState.asStateFlow()

    fun getInfo() {

        viewModelScope.launch {

            _infoState.value = LatestState.Loader(true)

            val response = RetrofitClient.retrofitBuilder.getInfo()
            if (response.isSuccessful){
                val body : ItemModel = response.body()!!
                _infoState.value = LatestState.Success(listOf(body))
                Log.d("body", "${listOf(body)}")
            }else{
                val errorBody = response.errorBody()
                _infoState.value = LatestState.Error(errorBody.toString()?: "")
            }

            _infoState.value = LatestState.Loader(false)
        }
    }

    override fun onCleared() {
        super.onCleared()

    }
}