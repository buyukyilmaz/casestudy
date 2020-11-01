package com.buyukyilmaz.dazncasestudy.network

import com.buyukyilmaz.dazncasestudy.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiFactory {

    private val api = getRetrofit().create(Api::class.java)

    fun getApi() = api

    private fun getRetrofit() = Retrofit.Builder()
        .client(getClient())
        .baseUrl(BuildConfig.HOST)
        .addConverterFactory(getGsonConverterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private fun getGsonConverterFactory(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        return GsonConverterFactory.create(gsonBuilder.create())
    }

    private fun getClient() = OkHttpClient().newBuilder()
        .connectTimeout(40, TimeUnit.SECONDS)
        .readTimeout(40, TimeUnit.SECONDS)
        .writeTimeout(40, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}