package ru.nsu.geochat.modules.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.modules.activity.main.MainActivity

class LoginFragment: Fragment(), ILoginView {

    private lateinit var presenter: ILoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.loginButton.setOnClickListener {
            val login = view.loginField.text.toString()
            val password = view.passwordField.text.toString()
            when {
                presenter.validatePassword(password) -> presenter.onLogin(login, password)
                else -> showErrorScreen(getString(R.string.error_password))
            }
        }
        return view
    }

    override fun onSuccessLogin() {
        val intent = Intent(context, MainActivity::class.java)
        activity?.startActivity(intent)
        activity?.finish()

    }

    override fun showErrorScreen(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: ILoginPresenter) {
        this.presenter = presenter
    }
}