package ru.nsu.geochat.modules.activity.main.chat

import ru.nsu.geochat.common.useCaseEngine.IUseCaseCallback
import ru.nsu.geochat.common.useCaseEngine.UseCaseHandler
import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.useCase.messages.MessagesList

class ChatPresenter(override val view: IChatView, val id: String) : IChatPresenter {

    override fun sendMessage(message: Message) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        val request = MessagesList()
        val requestValue = MessagesList.RequestValue(id)
        UseCaseHandler.instance.execute(
            request,
            requestValue,
            object : IUseCaseCallback<MessagesList.ResponseValue> {
                override fun onSuccess(response: MessagesList.ResponseValue) {
                    view.onChatLoaded(response.messages)
                }

                override fun onError() {
                    view.onError()
                }

            }
        )
    }
}