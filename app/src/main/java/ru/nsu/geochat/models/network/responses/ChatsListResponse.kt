package ru.nsu.geochat.models.network.responses

data class ChatsListResponse (
    val chatRoomID: String,
    val chatTitle: String,
    val lastAuthor: String,
    val lastMessage: String
)