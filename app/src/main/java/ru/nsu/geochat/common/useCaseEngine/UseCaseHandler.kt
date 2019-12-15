package ru.nsu.geochat.common.useCaseEngine

class UseCaseHandler private constructor() {

    private val useCaseScheduler : IUseCaseScheduler

    init {
        useCaseScheduler = UseCaseThreadPoolScheduler()
    }

    private object Holder {
        val INSTANCE = UseCaseHandler()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun <T: UseCase.RequestValue, R: UseCase.ResponseValue>
            execute(useCase: UseCase<T, R>, requestValue: T, callback: IUseCaseCallback<R>) {
        useCase.requestValue = requestValue
        //TODO add callback
        useCaseScheduler.execute(Runnable {
            useCase.run()
        })
    }

    fun <T: UseCase.ResponseValue> notifyResponse(response: T, useCaseCallback: IUseCaseCallback<T>) {
        useCaseScheduler.onResponse(response, useCaseCallback)
    }

    fun <T: UseCase.ResponseValue> notifyError(useCaseCallback: IUseCaseCallback<T>) {
        useCaseScheduler.onError(useCaseCallback)
    }
}