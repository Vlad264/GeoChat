package ru.nsu.geochat.modules.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    companion object {
        const val SERVER_URL = "http://"

        val instance: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build()

            retrofit.create(ApiService::class.java)
        }
    }
}