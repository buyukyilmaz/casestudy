package com.buyukyilmaz.dazncasestudy.ui.scores

import com.buyukyilmaz.dazncasestudy.base.presenter.IBasePresenter
import com.buyukyilmaz.dazncasestudy.base.view.IBaseView
import com.buyukyilmaz.dazncasestudy.entity.ScoreResponse

interface ScoreContract {
    interface Presenter : IBasePresenter {
        fun getScores()

        fun stopTimer()

        fun formatDate(date: String): String
    }

    interface View : IBaseView {
        fun updateRecyclerView(scores: ScoreResponse)
    }
}