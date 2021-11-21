package ru.maxmvaas.lesson_7_vasilev.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BridgesApi {
    private const val URL = "http://gdemost.handh.ru:1235/"

    val apiService: BridgesApiService = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(BridgesApiService::class.java)
}