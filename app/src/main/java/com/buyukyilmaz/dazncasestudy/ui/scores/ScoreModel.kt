package com.buyukyilmaz.dazncasestudy.ui.scores

import com.buyukyilmaz.dazncasestudy.base.model.BaseModel
import com.buyukyilmaz.dazncasestudy.entity.ScoreResponse
import com.buyukyilmaz.dazncasestudy.network.ServiceCallback

class ScoreModel : BaseModel() {

    fun getScores(listener: ServiceCallback<ScoreResponse>) {
        callService(getApi().getScores(), listener)
    }
}