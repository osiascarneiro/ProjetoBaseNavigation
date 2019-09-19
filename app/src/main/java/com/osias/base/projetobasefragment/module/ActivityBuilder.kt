package com.osias.base.projetobasefragment.module

import com.osias.base.projetobasefragment.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): MainActivity

}