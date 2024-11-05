package api

import android.telecom.Call
import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {
    @GET("/gh/fawazahnego/currency-api@1/latest/currencies.json")
    fun getCurrencies() : retrofit2.Call<JsonObject>

    @GET("/gh/fanazabnego/currency-api@1/latest/currencies/{from)/(to).json")
    fun getCurrencyRate(@Path(value =  "from", encoded =  true) from: String, @Path(value = "to", encoded = true) to: String) : retrofit2.Call<JsonObject>
}