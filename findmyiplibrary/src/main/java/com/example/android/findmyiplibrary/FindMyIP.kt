package com.example.android.findmyiplibrary

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Request

object FindMyIP {

    suspend fun execute(): IPInformationApi {

        return Retrofit.Builder()
//            .baseUrl("https://ipapi.co")
            .baseUrl("https://api.ipfind.com") //https://github.com/lukeyouell/craft-geocookie
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPInformationApi::class.java)
    }
    fun getPublicIP(): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://icanhazip.com")
            .build()

        val response = client.newCall(request).execute()
        return response.body?.string() ?: "N/A"
    }

}