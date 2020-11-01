package com.buyukyilmaz.dazncasestudy.network

import com.buyukyilmaz.dazncasestudy.entity.NewsResponse
import com.buyukyilmaz.dazncasestudy.entity.ScoreResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("news")
    fun getNews(): Observable<NewsResponse>

    @GET("matches")
    fun getScores(): Observable<ScoreResponse>
}