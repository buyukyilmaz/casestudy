package com.buyukyilmaz.dazncasestudy.ui.news.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.buyukyilmaz.dazncasestudy.base.view.BaseFragment
import com.buyukyilmaz.dazncasestudy.databinding.FragmentNewsBinding
import com.buyukyilmaz.dazncasestudy.entity.News
import com.buyukyilmaz.dazncasestudy.ui.news.newsdetail.NewsDetailActivity

class NewsFragment : BaseFragment<NewsContract.Presenter>(), NewsContract.View {

    private lateinit var binding: FragmentNewsBinding

    override fun setPresenter() = NewsPresenter(this)

    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.getNews()
    }

    override fun initRecyclerView(items: List<News>) {
        val adapter = NewsRecyclerAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        adapter.setItemClickListener {
            startActivity(NewsDetailActivity::class.java, intent = { putExtra(NewsDetailActivity.NEWS_BUNDLE_KEY, it) })
        }
    }
}