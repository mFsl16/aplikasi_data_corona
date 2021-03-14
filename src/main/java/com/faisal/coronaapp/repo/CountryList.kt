package com.faisal.coronaapp.repo

import com.google.gson.annotations.SerializedName

data class CountryList (

        @SerializedName("countries") val countries : List<Countries>
)

data class Countries (

        @SerializedName("name") val name : String,
        @SerializedName("iso2") val iso2 : String,
        @SerializedName("iso3") val iso3 : String
)