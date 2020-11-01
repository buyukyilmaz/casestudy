package com.buyukyilmaz.dazncasestudy.di

import com.buyukyilmaz.dazncasestudy.network.ApiFactory
import org.koin.dsl.module

val applicationModule = module {
    single { ApiFactory() }
}