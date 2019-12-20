package ru.nsu.geochat.modules.data.chats

import ru.nsu.geochat.models.Chat

interface IChatsDao {

    fun getChatsList(callback: IGetChatsCallback)

    interface IGetChatsCallback {
        fun onChatsLoaded(chats: List<Chat>)
    }
}