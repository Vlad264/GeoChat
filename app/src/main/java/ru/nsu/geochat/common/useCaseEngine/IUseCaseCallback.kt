package ru.nsu.geochat.common.useCaseEngine

interface IUseCaseCallback<T> {
    fun onSuccess(response: T)
    fun onError()
}