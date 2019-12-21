package ru.nsu.geochat.modules.activity.main.create

import ru.nsu.geochat.modules.base.IBaseView

interface ICreateView: IBaseView<ICreatePresenter> {
    fun onChatCreated()
    fun onError()
}