package com.example.projetoodonto

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import api.Endpoint
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import util.NetworkUtils.NetworkUtils
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        getCurre()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
        val intent = Intent(this, Tela2::class.java)
        startActivity(intent)
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
                Log.i("teste", "PASSOU AQUI")
                println(data.count())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                print("Deu falha")
                Log.i("teste", "deu erro")
            }
        })
    }
}