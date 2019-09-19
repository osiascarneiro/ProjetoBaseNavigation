package com.osias.base.projetobasefragment.model.remote

import androidx.lifecycle.LiveData
import com.osias.base.projetobasefragment.model.entity.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service  {

    @GET("posts")
    fun listPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<Post?>

}