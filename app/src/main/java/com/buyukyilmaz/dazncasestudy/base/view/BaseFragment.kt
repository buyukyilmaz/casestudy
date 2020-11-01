package com.buyukyilmaz.dazncasestudy.base.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.buyukyilmaz.dazncasestudy.base.presenter.IBasePresenter

abstract class BaseFragment<P : IBasePresenter> : Fragment(), IBaseView {

    protected lateinit var presenter: P

    abstract fun setPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = setPresenter()
    }

    override fun showLoading(show: Boolean) {
        getBaseActivity().showLoading(show)
    }

    protected fun getBaseActivity() = activity as BaseActivity<*>

    protected fun <T : BaseActivity<*>> startActivity(activityClass: Class<T>, bundle: Bundle? = null, intent: Intent.() -> Unit = {}) {
        getBaseActivity().startActivity(activityClass, bundle, intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}