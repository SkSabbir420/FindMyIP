package com.example.android.findmyiplibrary

import retrofit2.Response
import retrofit2.http.GET

interface IPInformationApi {

//    @GET("json/")
    @GET("/json/")
    suspend fun getIPInformation(): Response<IPInformation>
}