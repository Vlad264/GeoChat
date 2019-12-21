package ru.nsu.geochat.modules.activity.create

import android.os.Bundle
import ru.nsu.geochat.modules.base.BaseActivity

class CreateActivity: BaseActivity(CreateFragment()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = fragment as ICreateView
        val presenter = CreatePresenter(view)
        view.setPresenter(presenter)
    }
}