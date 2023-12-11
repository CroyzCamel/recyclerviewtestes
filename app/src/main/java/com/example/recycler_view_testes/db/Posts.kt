package com.example.recycler_view_testes.db

data class Posts(
    val id: String,
    val title: String,
    val body: String,
)

data class PostsComents(
    val id: String,
    val name: String,
    val email: String,
    val body: String,
)

data class PostsPosts(
    val id: Int,
    val title: String,
    val body: String,
)
