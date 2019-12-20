package ru.nsu.geochat.modules.useCase.chats

import ru.nsu.geochat.common.useCaseEngine.UseCase
import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.modules.data.Dao
import ru.nsu.geochat.modules.data.chats.IChatsDao

class ChatsList: UseCase<ChatsList.RequestValue, ChatsList.ResponseValue>() {

    override fun executeUseCase(requestValue: RequestValue) {
        Dao.instance.chatDao.getChatsList(
            object : IChatsDao.IGetChatsCallback {
                override fun onChatsLoaded(chats: List<Chat>) {
                    if (chats.isNotEmpty()) {
                        useCaseCallback.onSuccess(ResponseValue(chats))
                    } else {
                        useCaseCallback.onError()
                    }
                }

            }
        )
    }

    class RequestValue: UseCase.RequestValue

    class ResponseValue(chats: List<Chat>): UseCase.ResponseValue
}