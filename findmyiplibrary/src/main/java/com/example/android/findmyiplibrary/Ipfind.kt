package com.example.android.findmyiplibrary

data class Ipfind(
    val city: String,
    val continent: String,
    val continent_code: String,
    val country: String,
    val country_code: String,
    val county: String,
    val currency: String,
    val ip_address: String,
    val languages: List<String>,
    val latitude: Double,
    val longitude: Double,
    val owner: Any,
    val postal_code: String,
    val region: String,
    val region_code: String,
    val timezone: String,
    val warning: String
)