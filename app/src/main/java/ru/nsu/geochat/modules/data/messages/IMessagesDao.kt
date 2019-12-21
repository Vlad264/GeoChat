package ru.nsu.geochat.modules.data.messages

import ru.nsu.geochat.models.Message

interface IMessagesDao {

    fun getMessagesList(callback: IGetMessagesCallback)

    interface IGetMessagesCallback {
        fun onMessagesLoadad(messages: List<Message>)
    }
}