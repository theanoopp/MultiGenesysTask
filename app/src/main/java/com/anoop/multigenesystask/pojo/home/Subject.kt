package com.anoop.multigenesystask.pojo.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Subject(
    val branch: String,
    val branchId: Int,
    val common: Boolean,
    val count: String,
    val courseName: String?,
    val createdDateTime: String,
    val id: Int,
    val image: String,
    val notes: String?,
    val price: Int,
    val receiptId: String?,
    val releasingOn: String?,
    val semester: Int,
    val subjectName: String,
    val subscribed: Boolean,
    val updatedDateTime: String,
    val year: Int
): Parcelable