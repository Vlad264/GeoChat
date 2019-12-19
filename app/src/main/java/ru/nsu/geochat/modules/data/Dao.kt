package ru.nsu.geochat.modules.data

import ru.nsu.geochat.modules.data.login.ILoginDao
import ru.nsu.geochat.modules.data.login.NetworkLoginDao

class Dao private constructor(
    val loginDao: ILoginDao
) {
    private object Holder {
        val INSTANCE = Dao(NetworkLoginDao())
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}