package ru.nsu.geochat.modules.data.login

interface ILoginDao {
    fun tryLogin(name: String, password: String, callback: ITryLoginCallback)

    interface ITryLoginCallback {
        fun onLogin(token: String?)
    }
}