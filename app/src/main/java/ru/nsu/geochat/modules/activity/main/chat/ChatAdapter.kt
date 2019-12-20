package ru.nsu.geochat.modules.activity.main.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Message

class ChatAdapter(private val messages: List<Message>):
    RecyclerView.Adapter<ChatAdapter.MessageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        return MessageHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false))
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.author.text = messages[position].author
        holder.text.text = messages[position].text
    }


    inner class MessageHolder(view: View): RecyclerView.ViewHolder(view) {
        val author = view.messageAuthor
        val text = view.messageText
    }
}