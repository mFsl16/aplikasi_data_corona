package com.faisal.coronaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL = "https://covid19.mathdro.id/api/"

    val instance: API by lazy {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build()

        retrofit.create(API::class.java)
    }
}