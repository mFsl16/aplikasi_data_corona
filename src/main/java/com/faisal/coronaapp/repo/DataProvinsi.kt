package com.faisal.coronaapp.repo

data class DataProvinsi(
    val attributes: Attribute
)

data class Attribute(
    val  FID: Int,
    val Kode_Provi: Int,
    val Provinsi: String,
    val Kasus_Posi: Int,
    val Kasus_Semb: Int,
    val Kasus_Meni: Int
)