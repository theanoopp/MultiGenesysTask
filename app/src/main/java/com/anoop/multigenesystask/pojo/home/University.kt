package com.anoop.multigenesystask.pojo.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class University(
    val active: Boolean,
    val id: Int,
//    val image: String,
    val name: String
): Parcelable