package com.example.recycler_view_testes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recycler_view_testes.api.ApiServices
import com.example.recycler_view_testes.databinding.ActivityMain4Binding
import com.example.recycler_view_testes.db.PostsPosts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)



        addDadosUsuario()


    }

    fun addDadosUsuario() {
        binding.btPost.setOnClickListener {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val id = binding.id.text.toString().toInt()
            val title = binding.id.text.toString()
            val body = binding.body.text.toString()

            val newPosts = PostsPosts(id, title, body)
            val apiServices = retrofit.create(ApiServices::class.java)

            val call = apiServices.postPosts(newPosts).enqueue(object : Callback<List<PostsPosts>> {
                override fun onResponse(
                    call: Call<List<PostsPosts>>,
                    response: Response<List<PostsPosts>>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@MainActivity4, "DEU CERTO", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<PostsPosts>>, t: Throwable) {

                }
            })
        }
    }

}