package com.anoop.multigenesystask.pojo.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val active: Boolean,
    val admin: Boolean,
    val collegeName: String,
    val createdDateTime: String,
    val dob: String,
    val email: String,
    val id: Int,
    val isCourseExist: Boolean,
    val locality: String,
    val mobileNumber: String,
    val name: String,
    val paidUser: Boolean,
    val pincode: String,
    val profilePic: String,
    val referralCode: String,
    val sex: String,
    val updatedDateTime: String
): Parcelable