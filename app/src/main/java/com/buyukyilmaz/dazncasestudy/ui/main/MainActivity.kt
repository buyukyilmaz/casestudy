package com.buyukyilmaz.dazncasestudy.ui.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.buyukyilmaz.dazncasestudy.R
import com.buyukyilmaz.dazncasestudy.base.view.BaseActivity
import com.buyukyilmaz.dazncasestudy.databinding.ActivityMainBinding
import com.buyukyilmaz.dazncasestudy.ui.news.newslist.NewsFragment
import com.buyukyilmaz.dazncasestudy.ui.scores.ScoreFragment

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private var selectedItemPosition = 0
    override fun setPresenter() = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(binding.container.id, NewsFragment.newInstance())
        initSpinner()
    }

    private fun initSpinner() {
        ArrayAdapter.createFromResource(this, R.array.menu_items, R.layout.spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
                binding.spinner.adapter = adapter
            }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (selectedItemPosition == position) return

                selectedItemPosition = position

                when (position) {
                    0 -> {
                        replaceFragment(binding.container.id, NewsFragment.newInstance())
                    }
                    1 -> {
                        replaceFragment(binding.container.id, ScoreFragment.newInstance())
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}