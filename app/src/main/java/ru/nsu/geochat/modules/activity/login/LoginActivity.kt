package ru.nsu.geochat.modules.activity.login

import android.os.Bundle
import ru.nsu.geochat.modules.base.BaseActivity

class LoginActivity: BaseActivity(LoginFragment()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = fragment as ILoginView
        val presenter = LoginPresenter(view)
        view.setPresenter(presenter)
    }
}