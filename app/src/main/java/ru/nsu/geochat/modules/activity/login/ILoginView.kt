package ru.nsu.geochat.modules.activity.login

import ru.nsu.geochat.modules.base.IBaseView

interface ILoginView: IBaseView<ILoginPresenter> {
    fun onSuccessLogin()
    fun showErrorScreen(message: String)
}