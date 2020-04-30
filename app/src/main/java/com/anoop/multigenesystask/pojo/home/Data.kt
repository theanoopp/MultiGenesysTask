package com.anoop.multigenesystask.pojo.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val ads: List<Ad>,
    val profile: Profile,
    val subjects: List<Subject>,
    val universities: List<University>
): Parcelable