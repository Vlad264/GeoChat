package ru.nsu.geochat.modules.activity

import ru.nsu.geochat.modules.base.IBasePresenter
import ru.nsu.geochat.modules.base.IBaseView

interface ILoginView: IBaseView<IBasePresenter> {
    fun onSuccessLogin()
    fun showErrorScreen(message: String)
}