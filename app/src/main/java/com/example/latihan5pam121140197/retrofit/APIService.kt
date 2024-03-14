package com.example.latihan5pam121140197.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    val endpoint: APIEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        }
}