package ru.nsu.geochat.modules.useCase.messages

import ru.nsu.geochat.common.useCaseEngine.UseCase
import ru.nsu.geochat.models.Message
import ru.nsu.geochat.modules.data.Dao
import ru.nsu.geochat.modules.data.messages.IMessagesDao

class MessagesList: UseCase<MessagesList.RequestValue, MessagesList.ResponseValue>() {

    override fun executeUseCase(requestValue: RequestValue) {
        Dao.instance.messageDao.getMessagesList(
            requestValue.id,
            object : IMessagesDao.IGetMessagesCallback {
                override fun onMessagesLoadad(messages: List<Message>) {
                    if (messages.isNotEmpty()) {
                        useCaseCallback.onSuccess(ResponseValue(messages))
                    } else {
                        useCaseCallback.onError()
                    }
                }

            }
        )
    }

    class RequestValue(val id: String): UseCase.RequestValue

    class ResponseValue(val chats: List<Message>): UseCase.ResponseValue
}