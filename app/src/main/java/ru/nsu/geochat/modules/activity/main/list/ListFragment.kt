package ru.nsu.geochat.modules.activity.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Message

class ListFragment: Fragment(), IListView {

    private lateinit var presenter: IListPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        return view
    }

    override fun onListLoaded(chats: List<Message>) {

    }

    override fun onError() {
        Toast.makeText(context, "Error while loading list", Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: IListPresenter) {
        this.presenter = presenter
    }
}