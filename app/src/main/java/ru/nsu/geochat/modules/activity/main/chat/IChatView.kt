package ru.nsu.geochat.modules.activity.main.chat

import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.base.IBaseView

interface IChatView: IBaseView<IChatPresenter> {
    fun onChatLoaded(chat: List<Message>)
    fun addMessage(message: Message)
    fun onError()
}