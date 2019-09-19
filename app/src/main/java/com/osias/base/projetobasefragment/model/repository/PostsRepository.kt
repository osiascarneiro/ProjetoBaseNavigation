package com.osias.base.projetobasefragment.model.repository

import androidx.lifecycle.LiveData
import com.osias.base.projetobasefragment.model.entity.Post
import com.osias.base.projetobasefragment.model.local.PostDao
import com.osias.base.projetobasefragment.model.remote.Service
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface PostsErrorDelegate {
    fun serviceError(t: Throwable)
}

class PostsRepository (
    private val service: Service,
    private val postsDao: PostDao
) {

    var delegate: PostsErrorDelegate? = null

    fun getPosts(errorFunction: (Throwable) -> Unit): LiveData<List<Post>> {
        refreshDb(errorFunction)
        return postsDao.listPosts()
    }

    fun getPost(id: Int): LiveData<Post> {
        refreshDb(id)
        return postsDao.getPost(id)
    }

    private fun refreshDb(errorFunction: (Throwable) -> Unit) {
        GlobalScope.launch {
            val response = service.listPosts().execute()
            if(!response.isSuccessful) {
//                errorFunction(Throwable(response.errorBody().toString()))
                delegate?.serviceError(Throwable(response.errorBody().toString()))
            } else {
                response.body()?.forEach { postsDao.insertPost(it) }
            }
        }
    }

    private fun refreshDb(postId: Int) {
        GlobalScope.launch {
            val response = service.getPost(postId).execute().body() ?: return@launch
            //TODO: handle error
            postsDao.insertPost(response)
        }
    }

}