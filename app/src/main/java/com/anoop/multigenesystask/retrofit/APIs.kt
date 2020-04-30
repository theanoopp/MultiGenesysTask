package com.anoop.multigenesystask.retrofit

import com.anoop.multigenesystask.pojo.Branch
import com.anoop.multigenesystask.pojo.home.Home
import retrofit2.Response
import retrofit2.http.GET


interface APIs {

    //check for update
    @GET("api/v1/home")
    suspend fun getHomeData(
    ): Response<Home>

    //check for update
    @GET("api/v1/subjects")
    suspend fun getBranches(
    ): Response<Branch>


}