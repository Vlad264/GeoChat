package ru.nsu.geochat.modules.data.chats

import retrofit2.Response
import ru.nsu.geochat.models.Chat
import ru.nsu.geochat.models.network.responses.ChatResponse
import ru.nsu.geochat.modules.data.AuthInfo
import ru.nsu.geochat.modules.network.ApiService
import java.io.IOException

class NetworkChatsDao: IChatsDao {

    override fun getChatsList(callback: IChatsDao.IGetChatsCallback) {
        val response: Response<List<ChatResponse>> = try {
            ApiService.instance.getChatsList(AuthInfo.token).execute()
        } catch (e: IOException) {
            callback.onChatsLoaded(emptyList())
            return
        }

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                val result = mutableListOf<Chat>()
                for (c in body) {
                    result.add(Chat(id = c.chatRoomID, title = c.chatTitle, lastAuthor = c.lastAuthor, lastMessage = c.lastMessage, destination = "", description = ""))
                }
                callback.onChatsLoaded(result.toList())
            } else {
                callback.onChatsLoaded(emptyList())
            }
        } else {
            callback.onChatsLoaded(emptyList())
        }
    }
}