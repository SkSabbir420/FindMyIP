package com.example.android.findmyiplibrary

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPInformationApi {

    @GET("/")
    suspend fun getIPInformation(
        @Query("ip") ipAddress: String
    ): Response<Ipfind>

//    @GET("/json/")
//    suspend fun getIPInformation(): Response<IPInformation>

}