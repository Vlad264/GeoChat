package ru.nsu.geochat.common.useCaseEngine

abstract class UseCase<RequestType: UseCase.RequestValue, ResponseType: UseCase.ResponseValue> {

    lateinit var requestValue: RequestValue


    fun run() {
        executeUseCase(requestValue)
    }

    protected abstract fun executeUseCase(requestValue: RequestValue)

    interface RequestValue
    interface ResponseValue
}