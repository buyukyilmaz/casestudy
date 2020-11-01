package com.buyukyilmaz.dazncasestudy.base.model

import android.annotation.SuppressLint
import com.buyukyilmaz.dazncasestudy.network.ApiFactory
import com.buyukyilmaz.dazncasestudy.network.ServiceCallback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseModel : KoinComponent {

    private val apiFactory: ApiFactory by inject()

    protected fun getApi() = apiFactory.getApi()

    @SuppressLint("CheckResult")
    protected fun <T : Any> callService(call: Observable<T>, serviceCallback: ServiceCallback<T>) {
        call
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(

                { response ->
                    serviceCallback.onSuccess(response)
                },

                { error ->

                }
            )
    }
}