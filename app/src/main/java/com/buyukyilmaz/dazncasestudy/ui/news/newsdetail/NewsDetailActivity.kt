package com.buyukyilmaz.dazncasestudy.ui.news.newsdetail

import android.os.Bundle
import com.buyukyilmaz.dazncasestudy.base.view.BaseActivity
import com.buyukyilmaz.dazncasestudy.databinding.ActivityNewsDetailBinding
import com.buyukyilmaz.dazncasestudy.entity.News

class NewsDetailActivity : BaseActivity<NewsDetailContract.Presenter>(), NewsDetailContract.View {

    private lateinit var binding: ActivityNewsDetailBinding
    private var news: News? = null

    override fun setPresenter() = NewsDetailPresenter(this)

    companion object {
        const val NEWS_BUNDLE_KEY = "NEWS_BUNDLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        news = intent.extras?.getParcelable(NEWS_BUNDLE_KEY)
        news?.let { binding.webView.loadUrl(it.link) }
    }
}