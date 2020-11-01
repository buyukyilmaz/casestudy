package com.buyukyilmaz.dazncasestudy.ui.news.newslist

import com.buyukyilmaz.dazncasestudy.base.presenter.BasePresenter
import com.buyukyilmaz.dazncasestudy.entity.NewsResponse
import com.buyukyilmaz.dazncasestudy.network.ServiceCallback

class NewsPresenter(view: NewsContract.View) : BasePresenter<NewsContract.View>(view), NewsContract.Presenter {

    private val repository = NewsModel()

    override fun getNews() {
        view?.showLoading(true)
        repository.getNews(object : ServiceCallback<NewsResponse> {
            override fun onSuccess(response: NewsResponse?) {
                view?.showLoading(false)
                response?.let {
                    view?.initRecyclerView(it.news)
                }
            }
        })
    }
}