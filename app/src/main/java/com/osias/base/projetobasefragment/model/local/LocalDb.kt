package com.osias.base.projetobasefragment.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osias.base.projetobasefragment.model.entity.Post

/**
 * Created by osiascarneiro on 05/12/17.
 */

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class BancoLocal : RoomDatabase() {
    abstract fun postDao(): PostDao
}