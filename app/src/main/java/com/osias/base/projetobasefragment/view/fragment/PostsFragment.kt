package com.osias.base.projetobasefragment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.osias.base.projetobasefragment.R
import com.osias.base.projetobasefragment.viewmodel.PostsViewModel

class PostsFragment : BaseFragment<PostsViewModel>(PostsViewModel::class.java) {

    override fun getTitle(): String = "Posts"

    companion object {
        fun newInstance() = PostsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }



}
