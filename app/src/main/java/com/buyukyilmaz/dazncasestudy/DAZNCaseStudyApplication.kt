package com.buyukyilmaz.dazncasestudy

import android.app.Application
import com.buyukyilmaz.dazncasestudy.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DAZNCaseStudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DAZNCaseStudyApplication)
            modules(listOf(applicationModule))
        }
    }
}