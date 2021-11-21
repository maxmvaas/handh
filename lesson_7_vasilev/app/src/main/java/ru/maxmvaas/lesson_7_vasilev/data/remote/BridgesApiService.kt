package ru.maxmvaas.lesson_7_vasilev.data.remote

import retrofit2.http.GET
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge

interface BridgesApiService {
    @GET("bridges")
    suspend fun getBridges(): List<Bridge>
}