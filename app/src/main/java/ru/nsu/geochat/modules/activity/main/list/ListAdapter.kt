package ru.nsu.geochat.modules.activity.main.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.modules.activity.main.chat.ChatFragment
import ru.nsu.geochat.modules.activity.main.chat.ChatPresenter
import ru.nsu.geochat.modules.base.BaseActivity

class ListAdapter(private val chats: List<Chat>, private val activity: BaseActivity):
    RecyclerView.Adapter<ListAdapter.ChatHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        return ChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false))
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.title.text = chats[position].title
        holder.lastAuthor.text = chats[position].lastAuthor
        holder.lastMessage.text = chats[position].lastMessage

        holder.itemView.setOnClickListener {
            val fragment = ChatFragment()
            val presenter = ChatPresenter(fragment)
            fragment.setPresenter(presenter)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }


    inner class ChatHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.chatTitle
        val lastAuthor = view.lastAuthor
        val lastMessage = view.lastMessage
    }
}