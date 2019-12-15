package ru.nsu.geochat.modules.activity

import ru.nsu.geochat.modules.base.IBasePresenter

interface ILoginPresenter: IBasePresenter {
    val view: ILoginView
    fun validatePassword(password: String): Boolean
    fun onLogin(login: String, password: String)
}