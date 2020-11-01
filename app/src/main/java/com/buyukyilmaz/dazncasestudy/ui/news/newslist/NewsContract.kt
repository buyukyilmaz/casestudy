package com.buyukyilmaz.dazncasestudy.ui.news.newslist

import com.buyukyilmaz.dazncasestudy.base.presenter.IBasePresenter
import com.buyukyilmaz.dazncasestudy.base.view.IBaseView
import com.buyukyilmaz.dazncasestudy.entity.News

interface NewsContract {
    interface Presenter : IBasePresenter {
        fun getNews()
    }

    interface View : IBaseView {
        fun initRecyclerView(items: List<News>)
    }
}