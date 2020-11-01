package com.buyukyilmaz.dazncasestudy.ui.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.buyukyilmaz.dazncasestudy.base.view.BaseFragment
import com.buyukyilmaz.dazncasestudy.databinding.FragmentScoreBinding
import com.buyukyilmaz.dazncasestudy.entity.ScoreResponse

class ScoreFragment : BaseFragment<ScoreContract.Presenter>(), ScoreContract.View {

    private lateinit var binding: FragmentScoreBinding

    override fun setPresenter() = ScorePresenter(this)

    companion object {
        fun newInstance(): ScoreFragment {
            return ScoreFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        presenter.getScores()
    }

    override fun onStop() {
        super.onStop()
        presenter.stopTimer()
    }

    override fun updateRecyclerView(scores: ScoreResponse) {
        binding.tvDate.text = presenter.formatDate(scores.date)
        val adapter = ScoreRecyclerAdapter(scores.matches)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
}