package ru.nsu.geochat.modules.activity.main.chat

import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.base.IBasePresenter

interface IChatPresenter: IBasePresenter {
    val view: IChatView
    fun sendMessage(message: Message)
}