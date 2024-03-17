package com.example.latihan5pam121140197.retrofit

import com.example.latihan5pam121140197.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface APIEndPoint {
    @GET(value = "photos")
    fun getData(): Call<List<MainModel>>
}