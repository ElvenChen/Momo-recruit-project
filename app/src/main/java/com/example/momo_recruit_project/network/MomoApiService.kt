package com.example.momo_recruit_project.network


import com.example.momo_recruit_project.data.GeneralResult
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



private const val BASE_URL = "https://data.taipei/api/v1/dataset/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MomoApiService {

    // get animal-exhibit api
    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    suspend fun getAnimalExhibitList(
        @Query("scope") scope: String? = "resourceAquire"
    ): GeneralResult

}

object MomoApi {
    val retrofitService: MomoApiService by lazy { retrofit.create(MomoApiService::class.java) }
}