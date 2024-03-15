package com.example.latihan5pam121140197.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    val endpoint: APIEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(APIEndPoint::class.java)
        }
}