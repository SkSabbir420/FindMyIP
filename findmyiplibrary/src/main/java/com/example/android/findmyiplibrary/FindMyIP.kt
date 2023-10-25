package com.example.android.findmyiplibrary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FindMyIP {

    suspend fun execute(): String {

        return Retrofit.Builder()
            .baseUrl("https://ipapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPInformationApi::class.java)
            .getIPInformation()
            .message()
    }

}