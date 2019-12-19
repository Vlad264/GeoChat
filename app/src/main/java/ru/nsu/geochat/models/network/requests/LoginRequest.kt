package ru.nsu.geochat.models.network.requests

data class LoginRequest (
    val name: String,
    val password: String
)
