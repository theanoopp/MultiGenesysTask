package com.anoop.multigenesystask.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    const val BASE_URL = "https://5ea2d0c1b9f5ca00166c322a.mockapi.io/"

    fun create(): APIs {

        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }

        val oktHttpClient = OkHttpClient.Builder()
        oktHttpClient.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(oktHttpClient.build())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(APIs::class.java)
    }
}