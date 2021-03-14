package com.faisal.coronaapp.repo

import java.util.*

data class CountryDetail(
        val prpvinceState: String?,
        val countryRegion: String,
        val lastUpdate: Long,
        val lat: Float,
        val long: Float,
        val confirmed: Int,
        val recovered: Int,
        val deaths: Int,
        val active: Int,
        val admin2: String?,
        val fips: String?,
        val combineKey: String,
        val incidentRate: Float,
        val peopleTested: Int?,
        val peopleHospitalized: Int?,
        val uid: Int,
        val iso3: String
)