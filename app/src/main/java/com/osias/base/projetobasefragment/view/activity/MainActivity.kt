package com.osias.base.projetobasefragment.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osias.base.projetobasefragment.R
import com.osias.base.projetobasefragment.view.fragment.PostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PostsFragment.newInstance())
                .commitNow()
        }
    }

}
