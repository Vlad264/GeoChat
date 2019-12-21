package ru.nsu.geochat.modules.data.messages

import retrofit2.Response
import ru.nsu.geochat.models.Message
import ru.nsu.geochat.models.network.responses.MessageResponse
import ru.nsu.geochat.modules.network.ApiService
import java.io.IOException

class NetworkMessagesDao: IMessagesDao {
    override fun getMessagesList(id: String, callback: IMessagesDao.IGetMessagesCallback) {
        val response: Response<List<MessageResponse>> = try {
            ApiService.instance.getMessagesList(id).execute()
        } catch (e: IOException) {
            callback.onMessagesLoadad(emptyList())
            return
        }

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                val result = mutableListOf<Message>()
                for (m in body) {
                    result.add(Message(author = m.Sender, text = m.content))
                }
                callback.onMessagesLoadad(result)
            } else {
                callback.onMessagesLoadad(emptyList())
            }
        } else {
            callback.onMessagesLoadad(emptyList())
        }
    }
}