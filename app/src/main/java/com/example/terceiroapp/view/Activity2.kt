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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.terceiroapp.model.FolhaPagamento

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutFolha()
        }
    }
}

@Composable
fun LayoutFolha(){

    var nome by remember { mutableStateOf("") }
    var horasTrab by remember { mutableStateOf("") }
    var valorHora by remember { mutableStateOf("") }
    var folhaCalculada by remember{ mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = "Folha de Pagamento", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(28.dp))

        TextField(value= nome,
            onValueChange = { nome = it}, // toda vez que it alterar, nome recebe it
            label = {Text(text = "Nome do funcionario")})

        Spacer(modifier = Modifier.height(28.dp))

        TextField(value= horasTrab,
            onValueChange = { horasTrab = it}, // toda vez que it alterar, nome recebe it
            label = {Text(text = "Horas Trabalhadas")})

        Spacer(modifier = Modifier.height(28.dp))

        TextField(value= valorHora,
            onValueChange = { valorHora = it}, // toda vez que it alterar, nome recebe it
            label = {Text(text = "Valor Hora")})

        Spacer(modifier = Modifier.height(28.dp))

        Button(onClick = {

            if(nome.isEmpty()){
                nome = "Fulano da Silva"
            }
            val horasTrabFloat = horasTrab.toFloatOrNull() ?: 0f
            val valorHoraFloat = horasTrab.toFloatOrNull() ?: 0f
            var folha = FolhaPagamento(nome, horasTrabFloat, valorHoraFloat)

            folhaCalculada = "Funcionario: ${folha.nome}" +
                    "\n Horas Trab: ${horasTrabFloat}" +
                    "\n Valor da hora: ${valorHoraFloat}" +
                    "\n Salario Bruto: ${folha.calcularSaldoBruto()}" +
                    "\n INSS: ${folha.calcularINSS()}" +
                    "\n Salario liq: ${folha.calcularSalarioLiq()}"
        }){ 
            Text(text = "Calcular Folha")
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(text = "Folha Calculada: \n $folhaCalculada")

    }

}

@Preview
@Composable
fun Preview(){
    LayoutFolha()
}