package ru.nsu.geochat.modules.activity

import ru.nsu.geochat.modules.base.IBaseView

interface ILoginView: IBaseView<ILoginPresenter> {
    fun onSuccessLogin()
    fun showErrorScreen(message: String)
}