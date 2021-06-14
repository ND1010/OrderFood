package com.dhruv.orderfood.viewmodels

import androidx.lifecycle.MutableLiveData
import com.dhruv.orderfood.data.models.*
import com.dhruv.orderfood.data.repository.Repository
import com.dhruv.orderfood.utils.base.BaseViewModel
import com.dhruv.orderfood.utils.ext.loge
import com.dhruv.orderfood.utils.ext.route

class CategoryHomeViewModel(
    private val repository: Repository
) : BaseViewModel() {

    val listCategory: MutableLiveData<List<CategoryRaw>> = MutableLiveData()
    val screenSaverMaster: MutableLiveData<List<ScreenSaverMaster>> = MutableLiveData()
//    val itemList: MutableLiveData<List<ProductItem>> = MutableLiveData()

    fun getAllCategory() {
        compositeDisposable.route(repository.getAllCategory(),
            io = {
                if (it.isNotEmpty()) {
                    listCategory.postValue(it)
                } else {
                    listCategory.postValue(null)
                }
            },
            error = {
                listCategory.postValue(null)
                loge(it.localizedMessage)
            })
    }

    val listItem: MutableLiveData<List<ItemWithImage>> = MutableLiveData()
    fun getAllItem() {
        compositeDisposable.route(repository.getAllItem(),
            io = {
                if (it.isNotEmpty()) {
                    listItem.postValue(it)
                } else {
                    listItem.postValue(null)
                }
            },
            error = {
                listItem.postValue(null)
                loge(it.localizedMessage)
            })
    }
    /*fun getScreenImage(cat_id:Int) {
        compositeDisposable.route(repository.getItemListFromCategory(cat_id),
            io = {
                if (it.isNotEmpty()) {
                    itemList.postValue(it)
                } else {
                    itemList.postValue(null)
                }
            },
            error = {
                loge("Issue_loafList-> "+ it.localizedMessage)
                itemList.postValue(null)
            })
    }*/



}