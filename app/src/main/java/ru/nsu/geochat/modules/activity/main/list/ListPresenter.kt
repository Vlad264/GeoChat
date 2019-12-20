package ru.nsu.geochat.modules.activity.main.list

import ru.nsu.geochat.common.useCaseEngine.IUseCaseCallback
import ru.nsu.geochat.common.useCaseEngine.UseCaseHandler
import ru.nsu.geochat.modules.useCase.chats.ChatsList

class ListPresenter(override val view: IListView) : IListPresenter {
    override fun start() {
        val request = ChatsList()
        val requestValue = ChatsList.RequestValue()
        UseCaseHandler.instance.execute(
            request,
            requestValue,
            object : IUseCaseCallback<ChatsList.ResponseValue> {
                override fun onSuccess(response: ChatsList.ResponseValue) {
                    view.onListLoaded(response.chats)
                }

                override fun onError() {
                    view.onError()
                }

            }
        )
    }
}