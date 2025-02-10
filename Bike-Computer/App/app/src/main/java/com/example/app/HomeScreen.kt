package com.example.app

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(devicesList: List<String>, navController: NavController) {
    Scaffold(Modifier.fillMaxWidth()) { innerPadding ->

        // Add Electrium Mobility Logo Header Here

        RPDevices(
            devicesList,
            modifier = Modifier.padding(innerPadding),
            amount = 5, // max amount of devices to display on home screen
            navController = navController
        )

        // Add Bluetooth Button Here
    }
}