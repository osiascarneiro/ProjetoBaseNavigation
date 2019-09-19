package com.osias.base.projetobasefragment.module

import com.osias.base.projetobasefragment.ProjetoBaseFragmentApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    ApiModule::class])
interface ApiComponent: AndroidInjector<ProjetoBaseFragmentApplication> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<ProjetoBaseFragmentApplication> {
        override fun create(@BindsInstance instance: ProjetoBaseFragmentApplication): AndroidInjector<ProjetoBaseFragmentApplication>
    }

}
