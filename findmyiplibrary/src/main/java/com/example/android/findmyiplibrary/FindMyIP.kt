package com.example.android.findmyiplibrary

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FindMyIP {

    suspend fun execute(): IPInformationApi {

        return Retrofit.Builder()
//            .baseUrl("https://ipapi.co")
            .baseUrl("https://api.ipfind.com") //https://github.com/lukeyouell/craft-geocookie
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPInformationApi::class.java)
    }

}