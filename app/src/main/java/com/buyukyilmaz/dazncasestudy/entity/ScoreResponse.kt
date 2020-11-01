package com.buyukyilmaz.dazncasestudy.entity

data class ScoreResponse(
    val name: String,
    val format: String,
    val date: String,
    val matches: List<Match>
)