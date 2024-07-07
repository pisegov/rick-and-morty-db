package com.myaxa.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class NetworkDataSource {
    protected suspend inline fun <T> safeApiCall(crossinline block: suspend () -> T): Result<T> =
        try {
            withContext(Dispatchers.IO) {
                Result.success(block())
            }
        } catch (e: Throwable) {
            Result.failure(e)
        }
}
