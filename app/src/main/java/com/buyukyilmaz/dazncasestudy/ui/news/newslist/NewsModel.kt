package com.buyukyilmaz.dazncasestudy.ui.news.newslist

import com.buyukyilmaz.dazncasestudy.base.model.BaseModel
import com.buyukyilmaz.dazncasestudy.entity.NewsResponse
import com.buyukyilmaz.dazncasestudy.network.ServiceCallback

class NewsModel : BaseModel() {

    fun getNews(listener: ServiceCallback<NewsResponse>) {
        callService(getApi().getNews(), listener)
    }
}