package com.example.latihan5pam121140197.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private const val baseURL: String = "https://jsonplaceholder.typicode.com/"
    val endpoint: APIEndPoint
    get() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create( APIEndPoint::class.java )
    }
}