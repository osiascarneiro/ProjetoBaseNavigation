package com.osias.base.projetobasefragment.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.osias.base.projetobasefragment.model.entity.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Update
    fun updatePost(post: Post)

    @Delete
    fun deletePost(post: Post)

    @Query("SELECT * FROM post WHERE id = :id")
    fun getPost(id: Int): LiveData<Post>

    @Query("SELECT * FROM post")
    fun listPosts(): LiveData<List<Post>>

}