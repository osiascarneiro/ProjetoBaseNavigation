package com.osias.base.projetobasefragment.viewmodel

import com.osias.base.projetobasefragment.model.repository.PostsErrorDelegate
import com.osias.base.projetobasefragment.model.repository.PostsRepository
import javax.inject.Inject

class PostsViewModel @Inject constructor(val repository: PostsRepository): BaseViewModel() {

    val posts = repository.getPosts {
        error.value = it.message
    }

    init {
        repository.delegate = object: PostsErrorDelegate {
            override fun serviceError(t: Throwable) {
                error.value = t.message
            }

        }
    }

    override fun refreshItens() {
        repository.getPosts {
            error.value = it.message
        }
    }
}
