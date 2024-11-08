package com.example.testinghawk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testinghawk.ui.theme.TestingHawkTheme

class MainActivity : ComponentActivity() {

    private val dataStorage = HawkStorage()
    private val USER_REGISTRATION_DETAILS by lazy { "USER_REGISTRATION_DETAILS" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingHawkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android: " + getRegistrationDetails()?.deviceSerialNumber,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val serialNumber = getRegistrationDetails()?.deviceSerialNumber ?: "0"
        saveRegistrationDetails(RegistrationResponse(serialNumber + serialNumber.length))
    }

    fun getRegistrationDetails(): RegistrationResponse? =
        dataStorage.get<RegistrationResponse>(USER_REGISTRATION_DETAILS)

    fun saveRegistrationDetails(registrationResponse: RegistrationResponse) =
        dataStorage.put(USER_REGISTRATION_DETAILS, registrationResponse)
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingHawkTheme {
        Greeting("Android")
    }
}