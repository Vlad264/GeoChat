package ru.nsu.geochat.modules.useCase.login

import ru.nsu.geochat.common.useCaseEngine.UseCase
import ru.nsu.geochat.modules.data.AuthInfo
import ru.nsu.geochat.modules.data.Dao
import ru.nsu.geochat.modules.data.login.ILoginDao

class Login: UseCase<Login.RequestValue, Login.ResponseValue>() {

    override fun executeUseCase(requestValue: RequestValue) {
        Dao.instance.loginDao.tryLogin(
            requestValue.name,
            requestValue.password,
            object : ILoginDao.ITryLoginCallback {
                override fun onLogin(token: String?) {
                    if (token != null) {
                        AuthInfo.token = token
                        AuthInfo.name = requestValue.name
                        useCaseCallback.onSuccess(ResponseValue())
                    } else {
                        useCaseCallback.onError()
                    }
                }

            }
        )
    }

    class RequestValue(val name: String, val password: String): UseCase.RequestValue

    class ResponseValue: UseCase.ResponseValue
}