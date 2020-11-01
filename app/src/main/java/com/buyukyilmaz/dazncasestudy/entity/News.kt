package com.buyukyilmaz.dazncasestudy.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val id: Long,
    val title: String,
    val description: String,
    val date: String,
    val link: String,
    val picUrl: String
) : Parcelable