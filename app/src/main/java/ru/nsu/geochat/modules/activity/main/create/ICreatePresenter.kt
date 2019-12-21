package ru.nsu.geochat.modules.activity.main.create

import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.modules.base.IBasePresenter

interface ICreatePresenter: IBasePresenter {
    val view: ICreateView
    fun createChat(chat: Chat)
}