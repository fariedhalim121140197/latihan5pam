package com.example.latihan5pam121140197.retrofit
import retrofit2.http.GET
interface APIEndPoint {
    @GET("posts")
    fun getPosts()
}