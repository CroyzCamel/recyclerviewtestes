package com.example.recycler_view_testes.api

import com.example.recycler_view_testes.db.Posts
import com.example.recycler_view_testes.db.PostsComents
import com.example.recycler_view_testes.db.PostsPosts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("/posts")
    fun getposts() : Call<List<Posts>>

    @GET("/posts/{id}/comments")
    fun getPostsId(@Path("id") id :String) : Call<List<PostsComents>>

    @GET("/comments")
    fun getComments(@Query("postId") postId: String) : Call<List<PostsComents>>

    @POST("/posts")
    fun postPosts (@Body newPosts: PostsPosts) : Call<List<PostsPosts>>
}
