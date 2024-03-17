package com.example.latihan5pam121140197

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan5pam121140197.databinding.ActivityMainBinding
import com.example.latihan5pam121140197.retrofit.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag: String = "MainActivity"
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

/*    override fun onClick (v: View?) {
        when (v?.id) {
            R.id.btn1 -> {
                println("Hello World")
            }
        }
    }*/

    override fun onStart() {
        super.onStart()
        setupRecycleView()
        getData()
    }

    private fun setupRecycleView() {
        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }

    private fun getData () {
        APIService.endpoint.getData()
            .enqueue(object: Callback<List<MainModel>> {
                override fun onResponse(call: Call<List<MainModel>>, response: Response<List<MainModel>>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        printLog(result.toString())
                    }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    printLog(t.toString())
                }

            })
    }

    private fun printLog(message: String) {
        Log.d(tag, message)
    }
}

