package ru.nsu.geochat.modules.activity.main

import android.os.Bundle
import ru.nsu.geochat.modules.activity.main.list.IListView
import ru.nsu.geochat.modules.activity.main.list.ListFragment
import ru.nsu.geochat.modules.activity.main.list.ListPresenter
import ru.nsu.geochat.modules.base.BaseActivity

class MainActivity: BaseActivity(ListFragment()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = fragment as IListView
        val presenter = ListPresenter(fragment)
        view.setPresenter(presenter)
    }

}