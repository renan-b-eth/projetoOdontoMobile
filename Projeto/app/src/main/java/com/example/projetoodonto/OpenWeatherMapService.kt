package com.example.projetoodonto

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapService {
    data class Main(
        @SerializedName("temp")
        val temperature: Double,

        @SerializedName("humidity")
        val humidity: Int
    )
    data class Weather(
        @SerializedName("description")
        val description: String
    )
    data class WeatherResponse(
        @SerializedName("name")
        val city: String,
        @SerializedName("main")
        val main: Main,
        @SerializedName("weather")
        val weather: List<Weather>
    )
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherResponse
}