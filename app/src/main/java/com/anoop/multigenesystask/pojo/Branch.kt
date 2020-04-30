package com.anoop.multigenesystask.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Branch(
    val `data`: List<Data>,
    val message: String
) : Parcelable
{
    @Parcelize
    data class Data(
        val active: Boolean,
        val branchName: String,
        val courseId: String?,
        val id: Int,
        val image: String
    ): Parcelable

}