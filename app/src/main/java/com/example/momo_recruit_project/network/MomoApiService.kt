package com.example.momo_recruit_project.network

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import java.lang.reflect.Parameter


private const val BASE_URL = "https://data.taipei/api/v1/dataset/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MomoApiService {


}

object MomoApi {
    val retrofitService: MomoApiService by lazy { retrofit.create(MomoApiService::class.java) }
}