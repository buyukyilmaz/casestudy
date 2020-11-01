package com.buyukyilmaz.dazncasestudy.base.presenter

import com.buyukyilmaz.dazncasestudy.base.view.IBaseView

open class BasePresenter<V : IBaseView>(protected var view: V?) : IBasePresenter {

    override fun onDestroy() {
        view = null
    }
}