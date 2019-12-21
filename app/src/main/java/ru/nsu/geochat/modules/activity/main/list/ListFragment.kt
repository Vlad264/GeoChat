package ru.nsu.geochat.modules.activity.main.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.modules.activity.create.CreateActivity
import ru.nsu.geochat.modules.base.BaseActivity

class ListFragment: Fragment(), IListView {

    private lateinit var presenter: IListPresenter
    private lateinit var list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        presenter = ListPresenter(this)

        list = view.recyclerList
        list.layoutManager = LinearLayoutManager(activity)

        view.createChatButton.setOnClickListener {
            val intent = Intent(context, CreateActivity::class.java)
            activity?.startActivity(intent)
        }
        Log.i("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        return view
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onListLoaded(chats: List<Chat>) {
        list.adapter = activity?.let { ListAdapter(chats, it as BaseActivity) }
    }

    override fun onError() {
        Toast.makeText(context, "Error while loading list", Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: IListPresenter) {
        this.presenter = presenter
    }
}