package ru.nsu.geochat.common.useCaseEngine

class UseCaseCallbackWrapper<T: UseCase.ResponseValue> (
    private val callback: IUseCaseCallback<T>,
    private val useCaseHandler: UseCaseHandler
    ): IUseCaseCallback<T> {

    override fun onSuccess(response: T) {
        useCaseHandler.notifyResponse(response, callback)
    }

    override fun onError() {
        useCaseHandler.notifyError(callback)
    }


}