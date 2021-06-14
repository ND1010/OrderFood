package com.dhruv.orderfood.viewmodels

import androidx.lifecycle.MutableLiveData
import com.dhruv.orderfood.data.repository.Repository
import com.dhruv.orderfood.utils.base.BaseViewModel

class SplashViewModel(
    private val repository: Repository
): BaseViewModel(){

    var isLogin: MutableLiveData<Boolean> = MutableLiveData()

    fun getValue() {
        isLogin.postValue(repository.getIsLogin())
    }

}