package com.buyukyilmaz.dazncasestudy.base.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.buyukyilmaz.dazncasestudy.base.presenter.IBasePresenter
import com.buyukyilmaz.dazncasestudy.ui.dialog.LoadingDialog

abstract class BaseActivity<P : IBasePresenter> : AppCompatActivity(), IBaseView {

    protected lateinit var presenter: P
    private var loadingDialog: LoadingDialog? = null

    abstract fun setPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = setPresenter()
    }

    override fun showLoading(show: Boolean) {
        if (show) {
            loadingDialog = LoadingDialog()
            loadingDialog?.show(supportFragmentManager, "LoadingDialog")
        } else {
            loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

    fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }

    fun <T : BaseActivity<*>> startActivity(activityClass: Class<T>, bundle: Bundle? = null, intent: Intent.() -> Unit = {}) {
        val i = Intent(this, activityClass)
        i.intent()
        startActivity(i, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}