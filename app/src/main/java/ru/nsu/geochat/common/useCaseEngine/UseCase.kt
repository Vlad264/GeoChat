package ru.nsu.geochat.common.useCaseEngine

abstract class UseCase<T: UseCase.RequestValue, R: UseCase.ResponseValue> {

    lateinit var requestValue: T
    lateinit var useCaseCallback: IUseCaseCallback<R>


    fun run() {
        executeUseCase(requestValue)
    }

    protected abstract fun executeUseCase(requestValue: T)

    interface RequestValue
    interface ResponseValue
}