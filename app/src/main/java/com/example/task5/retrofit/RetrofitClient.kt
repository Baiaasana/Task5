package com.example.task5.retrofit

import com.example.task5.data.ItemModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val retrofitBuilder by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun retrofit() = retrofitBuilder
}

interface ApiService {

    @GET("5df987cc-b7b3-40e4-aa2e-a06c76244573")
    suspend fun getInfo(): Response<ItemModel>

}