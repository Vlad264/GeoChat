package ru.nsu.geochat.modules.activity.login

import ru.nsu.geochat.common.useCaseEngine.IUseCaseCallback
import ru.nsu.geochat.common.useCaseEngine.UseCaseHandler
import ru.nsu.geochat.modules.useCase.login.Login

class LoginPresenter(override val view: ILoginView): ILoginPresenter {

    override fun validatePassword(password: String): Boolean {
        return password.length > 4
    }

    override fun onLogin(login: String, password: String) {
        val request = Login()
        val requestValue = Login.RequestValue(login, password)
        UseCaseHandler.instance.execute(
            request,
            requestValue,
            object : IUseCaseCallback<Login.ResponseValue> {
                override fun onSuccess(response: Login.ResponseValue) {
                    view.onSuccessLogin()
                }

                override fun onError() {
                    view.showErrorScreen("Error on login")
                }

            }
        )
    }

    override fun start() {
        //Nothing to do
    }
}