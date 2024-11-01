package com.example.projetoodonto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EsqueceuSenha : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_esqueceu_senha)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val intent = Intent(this, Tela2::class.java)
        intent.putExtra("nome", "adm2@adm.com")
        startActivity(intent)

        var email3 = findViewById<TextView>(R.id.btnEsqueceuSenha)

        if(email3.equals("adm@adm.com")){
            val senhaPadrao = trocarSenha("adm2")
            Toast.makeText(this, "Senha Trocada com Sucesso, logue novamente", Toast.LENGTH_SHORT).show()
            val intent2 = Intent(this, Tela2::class.java)
            startActivity(intent2)
        }

    }

        companion object {
            fun trocarSenha(senha: String) {
                val senhaPadrao = "adm2"
            }
        }
}