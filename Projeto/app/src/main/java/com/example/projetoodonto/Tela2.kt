package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import api.Endpoint
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import util.NetworkUtils.NetworkUtils

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
            if(email.equals(emailPadrao) && senha.equals(senhaPadrao) || email.equals(emailPadrao) && senha.equals("adm2")){
                Log.i("teste", "LOGADO") /*IR PARA A TELA*/
                val intent = Intent(this, GerenciamentoEmpresa::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "EMAIL OU SENHA ERRADA", Toast.LENGTH_SHORT).show()
            }


            fun getCurre(){
                val retrofitClient = NetworkUtils.getRetroInstance("https://cdn.jsdelive.net/")
                val endpoint = retrofitClient.create(Endpoint::class.java)

                endpoint.getCurrencies().enqueue(object : retrofit2.Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        var data = mutableListOf<String>()

                        response.body()?.keySet()?.iterator()?.forEach {
                            data.add(it)
                        }
                        print("opa")
                        println(data.count())
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        print("Deu falha")
                    }
                })
            }

            /*fun chamarFuncaoDeA(esqueceuSenha: EsqueceuSenha){
                esqueceuSenha.trocarSenha()
            }*/

            val btnEsqueceuSenha = findViewById<Button>(R.id.btnEsqueceuSenha)
            btnEsqueceuSenha.setOnClickListener {
                try {
                    val intent = Intent(this, EsqueceuSenha::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
                }
            }

            val btnCadastro = findViewById<Button>(R.id.btnCadastro)
            btnCadastro.setOnClickListener {
                try {
                    val intent = Intent(this, CadastroConsultorio::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e("MainActivity", "Erro ao iniciar a atividade: ${e.message}")
                }
            }

        }
        fun getCurre(){
            val retrofitClient = NetworkUtils.getRetroInstance("https://cdn.jsdelive.net/")
            val endpoint = retrofitClient.create(Endpoint::class.java)

            endpoint.getCurrencies().enqueue(object : retrofit2.Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    var data = mutableListOf<String>()

                    response.body()?.keySet()?.iterator()?.forEach {
                        data.add(it)
                    }
                    print("opa")
                    println(data.count())
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    print("Deu falha")
                }
            })
        }

    }
}