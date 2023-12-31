package com.example.android.findmyip

import com.example.android.findmyiplibrary.FindMyIP
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class FindMyApiUnitTest {
    @Test
    fun findMyApiResponseTest() = runBlocking {
        val result = FindMyIP.execute().getIPInformation("182.252.81.85").code()
        assertEquals(200, result)
    }
}