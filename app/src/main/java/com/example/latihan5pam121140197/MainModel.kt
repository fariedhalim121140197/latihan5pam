package com.example.latihan5pam121140197

data class MainModel (val result: ArrayList<Result>) {
    data class Result (val id: Int, val title: String, val body: String)

}
