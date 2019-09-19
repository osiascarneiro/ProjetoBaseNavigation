package com.osias.base.projetobasefragment.module

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.osias.base.projetobasefragment.BuildConfig
import com.osias.base.projetobasefragment.ProjetoBaseFragmentApplication
import com.osias.base.projetobasefragment.model.local.BancoLocal
import com.osias.base.projetobasefragment.model.remote.Service
import com.osias.base.projetobasefragment.model.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule {

    @JvmStatic
    @Provides
    fun getAmbiente(): String = BuildConfig.SERVER_URL

    @JvmStatic
    @Provides
    @Reusable
    fun getRetrofit(): Retrofit {
        val ambiente = getAmbiente()

        val logging = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG) logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor {
                val requestBuilder = it.request().newBuilder()
                requestBuilder.header("Accept", "application/json")
                it.proceed(requestBuilder.build())
            }
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ambiente)
            .client(httpClient)
            .build()
    }

    @JvmStatic
    @Provides
    @Reusable
    fun getPostsRepository(service: Service, localDb: BancoLocal) = PostsRepository(service, localDb.postDao())

    @JvmStatic
    @Provides
    fun getClient(): Service = getRetrofit().create(Service::class.java)

    @JvmStatic
    @Provides
    @Reusable
    fun getDatabase(context: ProjetoBaseFragmentApplication): BancoLocal
            = Room.databaseBuilder(context, BancoLocal::class.java, "local_storage").build()

    @JvmStatic
    @Provides
    fun getSharedPref(context: ProjetoBaseFragmentApplication): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

}