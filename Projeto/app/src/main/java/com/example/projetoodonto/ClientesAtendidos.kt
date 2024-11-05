package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
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

class ClientesAtendidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_clientes_atendidos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = Intent(this, GerenciamentoEmpresa::class.java)

        var denunciar = findViewById<TextView>(R.id.edtDenunciar)

        denunciar.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("DENUNCIAR")
                .setMessage("PACIENTE DENUNCIADO COM SUCESSO, VOLTANDO PARA A PAGINA GERECIAMENTO DE EMPRESA")
                .setPositiveButton("OK") { _, _ ->
                }
                .setNegativeButton("Cancelar", null)
                .show()
            GlobalScope.launch {
                delay(4000)
                withContext(Dispatchers.Main) {
                    startActivity(intent)
                }
            }

        }
    }
}