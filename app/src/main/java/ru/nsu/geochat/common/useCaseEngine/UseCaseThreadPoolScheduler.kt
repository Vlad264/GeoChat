package ru.nsu.geochat.common.useCaseEngine

import android.os.Handler
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class UseCaseThreadPoolScheduler : IUseCaseScheduler {

    private companion object {
        const val POOL_SIZE = 2
        const val MAX_POOL_SIZE = 8
        const val TIMEOUT = 30L
    }

    private val executor = ThreadPoolExecutor(
        POOL_SIZE,
        MAX_POOL_SIZE,
        TIMEOUT,
        TimeUnit.SECONDS,
        ArrayBlockingQueue<Runnable>(POOL_SIZE)
    )

    private val handler = Handler()

    override fun execute(runnable: Runnable) {
        executor.execute(runnable)
    }

    override fun <T : UseCase.ResponseValue> onResponse(response: T, callback: IUseCaseCallback<T>) {
        handler.post {
            callback.onSuccess(response)
        }
    }

    override fun <T : UseCase.ResponseValue> onError(callback: IUseCaseCallback<T>) {
        handler.post {
            callback.onError()
        }
    }
}