package com.example.projetoodonto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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


        var email3 = findViewById<TextView>(R.id.editEsqueceuSenha)
        var btnProximo = findViewById<Button>(R.id.btnProximo)
        var btnCancelar = findViewById<TextView>(R.id.txtCancelar)
        val intent = Intent(this, Tela2::class.java)

        btnProximo.setOnClickListener {
            try {
                Toast.makeText(this, email3.text, Toast.LENGTH_SHORT).show()
                if(email3.text.toString().equals("adm@adm.com")){
                    Toast.makeText(this, "SENHA TROCADA COM SUCESSO, VOLTANDO PARA A TELA INICIAL NOVA SENHA = ADM2", Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(this)
                        .setTitle("SENHA TROCADA COM SUCESSO")
                        .setMessage("SENHA NOVA ADM2")
                        .setPositiveButton("OK") { _, _ ->
                        }
                        .setNegativeButton("Cancelar", null)
                        .show()
                    GlobalScope.launch {
                        delay(6000)
                        withContext(Dispatchers.Main) {
                            startActivity(intent)
                        }
                    }

                }

            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }

        btnCancelar.setOnClickListener {
            try {
                Toast.makeText(this, "VOLTANDO PARA A TELA INICIAL", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Tela2::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }


    }

        companion object {
            fun trocarSenha(senha: String) {
                val senhaPadrao = "adm2"
            }
        }
}