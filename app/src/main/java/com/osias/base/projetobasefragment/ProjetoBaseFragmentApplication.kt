package com.osias.base.projetobasefragment

import com.osias.base.projetobasefragment.module.DaggerApiComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ProjetoBaseFragmentApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerApiComponent
                                                                                .factory()
                                                                                .create(this)

}