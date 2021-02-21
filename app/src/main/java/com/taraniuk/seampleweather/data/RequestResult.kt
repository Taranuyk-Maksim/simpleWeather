package com.taraniuk.seampleweather.data

import java.lang.Exception

sealed class RequestResult<T> {

    data class OnSuccess<T>(val data: T) : RequestResult<T>()
    data class OnError<T>(val error: Exception) : RequestResult<T>()

    companion object {
        @JvmStatic
        fun <T> withValue(data: T): RequestResult<T> = OnSuccess(data)

        @JvmStatic
        fun <T> withError(error: Exception): RequestResult<T> = OnError(error)
    }
}