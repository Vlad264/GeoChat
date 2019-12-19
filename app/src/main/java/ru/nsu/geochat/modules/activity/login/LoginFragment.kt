package ru.nsu.geochat.modules.activity.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import ru.nsu.geochat.R

class LoginFragment: Fragment(), ILoginView {

    private lateinit var presenter: ILoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.loginButton.setOnClickListener {
            val login = view.loginField.toString()
            val password = view.passwordField.toString()
            when {
                presenter.validatePassword(password) -> presenter.onLogin(login, password)
                else -> showErrorScreen(getString(R.string.error_password))
            }
        }
        return view
    }

    override fun onSuccessLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorScreen(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: ILoginPresenter) {
        this.presenter = presenter
    }
}