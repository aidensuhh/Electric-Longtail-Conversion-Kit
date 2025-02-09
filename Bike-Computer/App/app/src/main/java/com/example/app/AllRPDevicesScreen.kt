package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme

class AllRPDevicesScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllRPDevices(
                        devicesList = listOf(
                            "JBL Speaker",
                            "iPhone 3",
                            "Someone's Laptop",
                            "AirPods",
                            "iPhone 4",
                            "iPhone 5",
                            "Someone's Bose Headphones",
                            "Computer",
                            "Smart Fridge",
                            "JBL Speaker",
                            "iPhone 3",
                            "Someone's Laptop",
                            "AirPods",
                            "iPhone 4",
                            "iPhone 5",
                            "Someone's Bose Headphones",
                            "Computer",
                            "Smart Fridge"
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color(red = 50, green = 200, blue = 50))) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            TextButton (
                onClick = { /*TODO*/ }, // go back to previous screen
                modifier = Modifier.width(40.dp)
            ) {
                Text(
                    text = "<",
                    color = Color.White,
                    fontSize = 34.sp
                )
            }
            Text(
                text = "Recently Paired Devices",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(start = 15.dp)
            )
        }
    }
}

@Composable
fun AllRPDevices(devicesList: List<String>, modifier: Modifier = Modifier, amount: Int = devicesList.size) {
    Column(modifier = modifier) {
        Header()
        DisplayDevices(devicesList, modifier = Modifier.verticalScroll(rememberScrollState()), amount)
    }
}

@Preview
@Composable
fun AllRPDevicesPreview() {
    AllRPDevices(
        devicesList = listOf(
            "JBL Speaker",
            "iPhone 3",
            "Someone's Laptop",
            "AirPods",
            "iPhone 4",
            "iPhone 5",
            "Someone's Bose Headphones",
            "Computer",
            "Smart Fridge",
            "JBL Speaker",
            "iPhone 3",
            "Someone's Laptop",
            "AirPods",
            "iPhone 4",
            "iPhone 5",
            "Someone's Bose Headphones",
            "Computer",
            "Smart Fridge"
        ),
        modifier = Modifier.padding(16.dp)
    )
}

