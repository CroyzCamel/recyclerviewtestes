package com.example.recycler_view_testes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_testes.R
import com.example.recycler_view_testes.adapter.PostsComentsAdapter
import com.example.recycler_view_testes.api.ApiServices
import com.example.recycler_view_testes.databinding.ActivityMain3Binding
import com.example.recycler_view_testes.db.PostsComents
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiServices = retrofit.create(ApiServices::class.java)

        binding.btAcitivty3.setOnClickListener {
            val id = binding.editId.text.toString()

            val call = apiServices.getComments(id).enqueue(object: Callback<List<PostsComents>> {
                override fun onResponse(call: Call<List<PostsComents>>, response: Response<List<PostsComents>>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null){
                            val adapter = PostsComentsAdapter(this@MainActivity3,body)
                            recyclerView.adapter = adapter
                        }
                    }
                }

                override fun onFailure(call: Call<List<PostsComents>>, t: Throwable) {

                }

            })

        }

        binding.btActivity4.setOnClickListener {
            startActivity(Intent(this@MainActivity3,MainActivity4::class.java))
        }
    }
}