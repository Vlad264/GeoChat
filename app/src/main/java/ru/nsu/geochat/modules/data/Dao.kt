package ru.nsu.geochat.modules.data

import ru.nsu.geochat.modules.data.chats.IChatsDao
import ru.nsu.geochat.modules.data.chats.NetworkChatsDao
import ru.nsu.geochat.modules.data.login.ILoginDao
import ru.nsu.geochat.modules.data.login.NetworkLoginDao

class Dao private constructor(
    val loginDao: ILoginDao,
    val chatDao: IChatsDao
) {
    private object Holder {
        val INSTANCE = Dao(NetworkLoginDao(), NetworkChatsDao())
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}