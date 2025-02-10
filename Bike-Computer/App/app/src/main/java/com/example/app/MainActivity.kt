package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.ui.theme.AppTheme

val DEVICES_LIST = listOf(
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
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "HomeScreen", builder = {
                composable(route = "HomeScreen", content = { HomeScreen(navController = navController, devicesList = DEVICES_LIST) })
                composable(route = "AllRPDevicesScreen", content = { AllRPDevicesScreen(navController = navController, devicesList = DEVICES_LIST) })
            })
        }
    }
}