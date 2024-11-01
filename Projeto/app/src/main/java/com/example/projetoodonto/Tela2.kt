package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela2 : AppCompatActivity(){
    private lateinit var email2:EditText
    private lateinit var senha2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

            email2 = findViewById(R.id.edtEmail)
            senha2 = findViewById(R.id.edtSenha)

            val button = findViewById<Button>(R.id.btnLogar)
        button.setOnClickListener {
            val emailPadrao = "adm@adm.com"
            val senhaPadrao = "adm"
            val email = email2.text.toString();
            val senha = senha2.text.toString();
            if(email.equals(emailPadrao) && senha.equals(senhaPadrao)){
                Log.i("teste", "LOGADO") /*IR PARA A TELA*/
                val intent = Intent(this, GerenciamentoEmpresa::class.java)
                startActivity(intent)
            }




            /*fun chamarFuncaoDeA(esqueceuSenha: EsqueceuSenha){
                esqueceuSenha.trocarSenha()
            }*/

            val textEsqueceu = findViewById<Button>(R.id.btnEsqueceuSenha)
            textEsqueceu.setOnClickListener{
                val intent2 = Intent(this, EsqueceuSenha::class.java)
                startActivity(intent2)
            }

        }
    }
}