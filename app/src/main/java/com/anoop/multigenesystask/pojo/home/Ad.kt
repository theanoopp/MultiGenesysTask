package com.anoop.multigenesystask.pojo.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ad(
    val active: Boolean,
    val adId: Int,
    val adTitle: String,
    val sequence: Int,
    val url: String
): Parcelable