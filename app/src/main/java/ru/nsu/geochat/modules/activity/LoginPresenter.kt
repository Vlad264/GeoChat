package ru.nsu.geochat.modules.activity

class LoginPresenter(override val view: ILoginView): ILoginPresenter {
    override fun validatePassword(password: String): Boolean {
        return password.length > 4
    }

    override fun onLogin(login: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
    }
}