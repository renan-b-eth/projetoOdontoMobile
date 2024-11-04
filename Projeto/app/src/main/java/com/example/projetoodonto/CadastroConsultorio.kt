package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

class CadastroConsultorio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_consultorio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        var nomeConsultorio = findViewById<EditText>(R.id.edtNomeConsultorio)
        var nomeResponsavel = findViewById<EditText>(R.id.edtResponsavel)
        var email = findViewById<EditText>(R.id.edtEmail2)
        var senha = findViewById<EditText>(R.id.edtSenha3)

        var btnCadatro = findViewById<Button>(R.id.btnCadastro2)
        val intent = Intent(this, Tela2::class.java)

        btnCadatro.setOnClickListener {
            Toast.makeText(this, "Cadastro feito com sucesso", Toast.LENGTH_SHORT).show()

                AlertDialog.Builder(this)
                    .setTitle("SEGUE OS DADOS")
                    .setMessage("SEGUE OS DADOS Nome consultorio: ${nomeConsultorio.text.toString()} \\n Nome Responsavel: ${nomeResponsavel.text.toString()} \\n Email: ${email.text.toString()}")
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
        }
}