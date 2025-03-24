package com.example.app

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app.service.BluetoothService
import com.example.app.model.ESPDevice

@Composable
fun HomeScreen(
    navController: NavController,
    bluetoothService: BluetoothService
) {
    val discoveredDevices by bluetoothService.discoveredDevices.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("ESP Device Scanner") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            RPDevices(
                devicesList = discoveredDevices.map { it.name },
                modifier = Modifier.padding(16.dp),
                amount = 5,
                navController = navController,
                onDeviceClick = { index ->
                    if (index < discoveredDevices.size) {
                        bluetoothService.connectToDevice(discoveredDevices[index])
                    }
                }
            )
        }
    }
}