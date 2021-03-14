package com.faisal.coronaapp.api

import com.faisal.coronaapp.repo.CountryDetail
import com.faisal.coronaapp.repo.CountryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("countries/")
    fun getCountryList() : Call<CountryList>

    @GET("countries/{country}/confirmed")
    fun getCounrtyDetail(@Path("country") country: String) : Call<ArrayList<CountryDetail>>

}