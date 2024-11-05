package com.example.projetoodonto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

class GerenciamentoEmpresa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gerenciamento_empresa)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        var verEmpresa1 = findViewById<TextView>(R.id.edtPro1)
        val verEmpresa2 = findViewById<TextView>(R.id.edtPro2)
        val verEmpresa3 = findViewById<TextView>(R.id.edtPro3)
        val intent = Intent(this, Tela2::class.java)

        verEmpresa1.setOnClickListener {
            try {
                val intent = Intent(this, VerProfissionais::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }

        verEmpresa2.setOnClickListener {
            try {
                Toast.makeText(this, "ATUALIZAÇÃO NA PROXIMA SPRINT FEATURE", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }

        verEmpresa3.setOnClickListener {
            try {
                Toast.makeText(this, "ATUALIZAÇÃO NA PROXIMA SPRINT FEATURE", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }

        var deslogar = findViewById<TextView>(R.id.edtDeslogar)

        deslogar.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("DESLOGAR")
                .setMessage("VOCÊ SERÁ DESLOGADO COM 5 SEGUNDOS")
                .setPositiveButton("OK") { _, _ ->
                }
                .setNegativeButton("Cancelar", null)
                .show()
            GlobalScope.launch {
                delay(5000)
                withContext(Dispatchers.Main) {
                    startActivity(intent)
                }
            }

        }


    }
}