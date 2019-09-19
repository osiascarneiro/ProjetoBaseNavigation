package com.osias.base.projetobasefragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    var error = MutableLiveData<String>()

    abstract fun refreshItens()

}