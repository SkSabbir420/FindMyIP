package com.example.android.findmyip

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.findmyip.ui.theme.FindMyIPTheme
import com.example.android.findmyiplibrary.FindMyIP
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var information by mutableStateOf<String>("")
        var progressStatus by mutableStateOf(true)

        GlobalScope.launch {
            val myIp = FindMyIP.getPublicIP()
//            Log.d("myIpp",myIp)
            information = FindMyIP.execute().getIPInformation(myIp).body().toString()
            progressStatus = false
//            Log.d("IpInformaion",information)
        }

        setContent {
            FindMyIPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FindMyIPScreen(information,progressStatus)
                }
            }
        }
    }
}

@Composable
fun FindMyIPScreen(information:String,progressStatus:Boolean) {
    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (progressStatus)
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        )
        Text(text = "$information")
    }

}