package com.example.projetoodonto

import android.content.Context
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
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        // Função para fazer a requisição e exibir os dados
        fun getWeather(context: Context, city: String, apiKey: String) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service
            = retrofit.create(OpenWeatherMapService::class.java)

            CoroutineScope(Dispatchers.IO).launch() {
                try {
                    val response = service.getWeather(city, apiKey)
                    withContext(Dispatchers.Main) {
                        val weather = response
                        print(response)
                        if (weather != null) {
                            Toast.makeText(
                                context,
                                "Cidade: ${weather.city}\nTemperatura: ${weather.main.temperature}°C\nDescrição: ${weather.weather[0].description}",
                                Toast.LENGTH_LONG
                            ).show()


                            println("ENTROU AQUI")
                        } else {
                            print("DEU ERRO")
                            Toast.makeText(context, "Erro ao buscar dados do clima", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    // Tratar exceções aqui
                    println("Erro: $e")
                }
            }
        }

        val apiKey = "1ace3d440c70638365f3d775e99ad6b9"
        getWeather(this,"Sao Paulo", apiKey)
        print("passou aqui")


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