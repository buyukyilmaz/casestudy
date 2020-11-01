package com.buyukyilmaz.dazncasestudy.ui.scores

import android.os.CountDownTimer
import com.buyukyilmaz.dazncasestudy.base.presenter.BasePresenter
import com.buyukyilmaz.dazncasestudy.entity.ScoreResponse
import com.buyukyilmaz.dazncasestudy.network.ServiceCallback
import java.text.SimpleDateFormat
import java.util.*

class ScorePresenter(view: ScoreContract.View) : BasePresenter<ScoreContract.View>(view), ScoreContract.Presenter {

    private val repository = ScoreModel()

    private var timer = object : CountDownTimer(30000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            getScores()
        }
    }

    override fun getScores() {
        view?.showLoading(true)
        repository.getScores(object : ServiceCallback<ScoreResponse> {
            override fun onSuccess(response: ScoreResponse?) {
                view?.showLoading(false)
                response?.let { view?.updateRecyclerView(it) }
                resetTimer()
            }
        })
    }

    private fun resetTimer() {
        timer.cancel()
        timer.start()
    }

    override fun stopTimer() {
        timer.cancel()
    }

    override fun formatDate(date: String): String {
        val parsedDateObj = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(date)
        return SimpleDateFormat("dd MMM yyyy", Locale.US).format(parsedDateObj)
    }
}