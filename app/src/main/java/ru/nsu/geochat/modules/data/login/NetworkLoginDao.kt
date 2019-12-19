package ru.nsu.geochat.modules.data.login

import android.util.Log
import retrofit2.Response
import ru.nsu.geochat.models.network.requests.LoginRequest
import ru.nsu.geochat.models.network.responses.LoginResponse
import ru.nsu.geochat.modules.network.ApiService
import java.io.IOException

class NetworkLoginDao : ILoginDao {

    override fun tryLogin(name: String, password: String, callback: ILoginDao.ITryLoginCallback) {
        val loginRequest = LoginRequest(name, password)

        val response: Response<LoginResponse> = try {
            ApiService.instance.loginUser(loginRequest).execute()
        } catch (e: IOException) {
            callback.onLogin(null)
            return
        }

        if (response.isSuccessful) {
            val loginResponse = response.body()
            if (loginResponse != null) {
                callback.onLogin(loginResponse.sessionId)
            } else {
                callback.onLogin(null)
            }
        } else {
            callback.onLogin(null)
        }
    }
}