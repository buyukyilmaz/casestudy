package com.buyukyilmaz.dazncasestudy.network

interface ServiceCallback<T : Any> {

    fun onSuccess(response: T?) {}

    fun onError() {}
}