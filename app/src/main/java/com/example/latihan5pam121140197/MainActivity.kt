package com.example.latihan5pam121140197

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.latihan5pam121140197.retrofit.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    override fun onStart() {
        super.onStart()
        getData()
    }
    private fun getData() {
        APIService.endpoint.getPosts()
            .enqueue(object : Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    if (response.isSuccessful) {
                        val result  = response.body()
                        showPosts( result!! )
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    printLog(t.toString())
                }
            }
            )

    }

    private fun printLog(toString: String) {
        Log.d(TAG, toString)
    }

    private fun showPosts(posts: MainModel) {
        for (post in posts) {
            printLog("$posts.Result.body")
        }
    }
}