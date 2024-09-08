package com.example.terceiroapp.model

class FolhaPagamento(var nome: String, var horasTrab: Float, var valorHora: Float){

    fun calcularSaldoBruto(): Float{
        return horasTrab * valorHora
    }

    fun calcularINSS(): Float{
        return calcularSaldoBruto() * 0.08f
    }

    fun calcularIR(): Float{
        return calcularSaldoBruto() * 0.09f
    }

    fun calcularSalarioLiq(): Float{
        return calcularSaldoBruto() - calcularINSS() - calcularIR()
    }

}