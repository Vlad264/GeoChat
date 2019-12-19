package ru.nsu.geochat.modules.activity.main.list

import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.base.IBaseView

interface IListView: IBaseView<IListPresenter> {
    fun onListLoaded(chats: List<Message>)
    fun onError()
}