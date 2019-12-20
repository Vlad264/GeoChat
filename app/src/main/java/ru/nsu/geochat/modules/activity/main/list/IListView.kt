package ru.nsu.geochat.modules.activity.main.list

import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.modules.base.IBaseView

interface IListView: IBaseView<IListPresenter> {
    fun onListLoaded(chats: List<Chat>)
    fun onError()
}