package ru.nsu.geochat.models.network.responses

data class MessageResponse (
    val type: String,
    val content: String,
    val Sender: String
)