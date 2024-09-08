package com.example.terceiroapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TemperaturaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemperaturaLayout()

        }
    }
}

@Composable
fun TemperaturaLayout(){
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf(0f) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        TextField(value = celsius,
            onValueChange = {
                celsius = it
                var celciusFloat = celsius.toFloatOrNull() ?: 0f
                fahrenheit = (celciusFloat * 9/5) + 32
        },
            label = { Text(text = "Informe a temperatura em Celsius")})


        Spacer(modifier =  Modifier.height(30.dp))

        Text(text = "Temperatura em Fah: $fahrenheit")
    }

}