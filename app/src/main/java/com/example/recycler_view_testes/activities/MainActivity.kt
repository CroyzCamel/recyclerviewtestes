package com.example.recycler_view_testes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_testes.R
import com.example.recycler_view_testes.adapter.PostsAdapter
import com.example.recycler_view_testes.api.ApiServices
import com.example.recycler_view_testes.databinding.ActivityMainBinding
import com.example.recycler_view_testes.db.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiServices = retrofit.create(ApiServices::class.java)
        val call = apiServices.getposts()

        call.enqueue(object : Callback <List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null) {
                        val adapter = PostsAdapter(this@MainActivity,body)
                        recyclerView.adapter = adapter

                    }
                }
            }
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }
        })

        binding.btAcitivty.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }

    }

}