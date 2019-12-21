package ru.nsu.geochat.modules.data

import ru.nsu.geochat.modules.data.chats.IChatsDao
import ru.nsu.geochat.modules.data.chats.NetworkChatsDao
import ru.nsu.geochat.modules.data.login.ILoginDao
import ru.nsu.geochat.modules.data.login.NetworkLoginDao
import ru.nsu.geochat.modules.data.messages.IMessagesDao
import ru.nsu.geochat.modules.data.messages.NetworkMessagesDao

class Dao private constructor(
    val loginDao: ILoginDao,
    val chatDao: IChatsDao,
    val messageDao: IMessagesDao
) {
    private object Holder {
        val INSTANCE = Dao(NetworkLoginDao(), NetworkChatsDao(), NetworkMessagesDao())
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}