package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerProfissionais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_profissionais)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var verClientesClaudio = findViewById<TextView>(R.id.edtClientesClaudio)

        verClientesClaudio.setOnClickListener {
            try {
                val intent = Intent(this, ClientesAtendidos::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
            }
        }



    }
}