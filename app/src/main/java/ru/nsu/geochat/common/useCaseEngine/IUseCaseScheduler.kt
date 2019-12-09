package ru.nsu.geochat.common.useCaseEngine

interface IUseCaseScheduler {

    fun execute(runnable: Runnable)

    fun <T: UseCase.ResponseValue> onResume(response: T, callback: IUseCaseCallback<T>)

    fun <T: UseCase.ResponseValue> onError(callback: IUseCaseCallback<T>)
}