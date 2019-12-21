package ru.nsu.geochat.modules.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.nsu.geochat.models.Message
import ru.nsu.geochat.models.network.requests.LoginRequest
import ru.nsu.geochat.models.network.responses.ChatResponse
import ru.nsu.geochat.models.network.responses.LoginResponse

interface ApiService {
    companion object {
        const val SERVER_DOMAIN = "192.168.1.111:8080"
        const val SERVER_URL = "http://$SERVER_DOMAIN/"

        val instance: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build()

            retrofit.create(ApiService::class.java)
        }
    }

    @POST("/api/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/api/user/chat/{token}")
    fun getChatsList(@Path("token") token: String): Call<List<ChatResponse>>

    @GET("/api/chat/allmessage/{id}")
    fun getMessagesList(@Path("id") id: String): Call<List<Message>>
}