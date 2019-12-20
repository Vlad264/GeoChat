package ru.nsu.geochat.models

data class Chat (
    val id: String,
    val title: String,
    val lastMessage: String,
    val lastAuthor: String
)