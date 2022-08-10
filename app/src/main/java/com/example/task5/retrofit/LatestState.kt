package com.example.task5.retrofit

sealed class LatestState<out T> {
    data class Success<out T : Any>(val info: T) : LatestState<T>()
    data class Error(val error: String) : LatestState<Nothing>()
    data class Loader(val isLoading: Boolean) : LatestState<Nothing>()
}
