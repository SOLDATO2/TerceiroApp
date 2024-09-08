package com.example.terceiroapp.model

class Contato(var nome: String, var fone: String, var email: String) {

    init {
        if (nome.isEmpty()){
            nome = "Não Informado"
        }

        if (fone.isEmpty()){
            fone = "Não informado"
        }

        if(fone.isEmpty()){
            fone = "Não informado"
        }
    }

    override fun toString(): String {
        return "Contato(nome='$nome', fone='$fone', email='$email')"
    }
}