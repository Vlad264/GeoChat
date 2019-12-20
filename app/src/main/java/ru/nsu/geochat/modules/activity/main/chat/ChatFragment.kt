package ru.nsu.geochat.modules.activity.main.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_chat.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.data.AuthInfo

class ChatFragment: Fragment(), IChatView {

    private lateinit var presenter: IChatPresenter
    private lateinit var list: RecyclerView
    private lateinit var messages: MutableList<Message>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        list = view.recyclerListChat
        list.layoutManager = LinearLayoutManager(activity)

        view.sendButton.setOnClickListener {
            val text = view.messageText.text.toString()
            if (text.isNotEmpty()) {
                presenter.sendMessage(Message(author = AuthInfo.name, text = text))
                view.messageText.text.clear()
            }
        }

        return view
    }

    override fun onChatLoaded(chat: List<Message>) {
        messages = chat.toMutableList()
        updateChat()
    }

    override fun addMessage(message: Message) {
        messages.add(message)
        updateChat()
    }

    override fun onError() {
        Toast.makeText(context, "Error on loading chat", Toast.LENGTH_SHORT).show()
    }

    override fun updateChat() {
        list.adapter = ChatAdapter(messages.toList())
    }

    override fun setPresenter(presenter: IChatPresenter) {
        this.presenter = presenter
    }
}