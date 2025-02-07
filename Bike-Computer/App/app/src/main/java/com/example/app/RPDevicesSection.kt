package com.example.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun RPDevicesSection() {
    Column {
        Title()

    }
}

@Composable
private fun Title() {
    Text(
        text = "Recently Paired Devices:",
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun DisplayDevices(devicesList: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy((-8).dp)) {
        devicesList.forEach { device ->
            Button(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = ButtonDefaults.outlinedButtonBorder,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = device,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun RPDevices(devicesList: List<String>) {
    Column {
        Title()
        DisplayDevices(devicesList)
    }
}

@Preview(showBackground = true)
@Composable
fun RPDevicesPreview() {
    RPDevices(
        devicesList = listOf(
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
    )
}

