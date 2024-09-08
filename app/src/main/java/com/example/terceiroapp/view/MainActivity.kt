package com.example.terceiroapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.terceiroapp.model.Contato

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutMain()
        }
    }
}

@Composable
fun LayoutMain(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Button(onClick = {
            var intent = Intent(context, ContatoActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Ir para Contato activity")
        }

        Button(onClick = {
            var intent = Intent(context, MainActivity2::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Ir para Activity2")
        }

        Button(onClick = {
            var intent = Intent(context, TemperaturaActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Ir para conversao de temperatura")
        }
    }
}

