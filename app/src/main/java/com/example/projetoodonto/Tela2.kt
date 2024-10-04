package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
            val button = findViewById<Button>(R.id.btnLogar)
        button.setOnClickListener {
            val emailPadrao = "adm@adm.com"
            val senhaPadrao = "adm"
            val email = R.id.edtEmail.toString()
            val senha = R.id.edtSenha.toString()
            if(email.equals(emailPadrao) && senha.equals(senhaPadrao)){
                println("LOGADO") /*IR PARA A TELA*/
            }

        }
    }
}