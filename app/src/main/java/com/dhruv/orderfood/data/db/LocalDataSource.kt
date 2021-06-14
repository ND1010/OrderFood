package com.dhruv.orderfood.data.db

import com.dhruv.orderfood.data.models.*
import com.dhruv.orderfood.utils.ext.doBack
import com.dhruv.orderfood.utils.ext.loge
import com.dhruv.orderfood.utils.ext.logi

open class LocalDataSource constructor(
    private val screenSeverDao: ScreenSeverDao
) {
    fun getScreenSaver()=screenSeverDao.all

    fun getAllCategory()= screenSeverDao.allCategory()

    fun getAllItem()= screenSeverDao.allItem()

    //fun getAllItemListFromCat(cat_id: Int)= screenSeverDao.allItemList(cat_id)

    fun insertScreenSever(list: List<ScreenSaverMaster>){
        doBack(
            action = {
                screenSeverDao.insertAllScreenSever(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

    fun insertCategoryItem(list: List<CategoryImage>) {
        doBack(
            action = {
                screenSeverDao.insertAllCategoryImage(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

    fun insertCategoryMaster(list: List<CategoryMaster>) {
        doBack(
            action = {
                screenSeverDao.insertAllCategoryMaster(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

    fun insertItemCategoryMapping(list: List<ItemCategoryMapping>) {
        doBack(
            action = {
                screenSeverDao.insertAllItemCategoryMapping(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

    fun insertItemImage(list: List<ItemImage>) {
        doBack(
            action = {
                screenSeverDao.insertAllItemImage(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

    fun insertItem(list: List<Item>) {
        doBack(
            action = {
                screenSeverDao.insertitem(list)
            },
            success = { logi("success insert screen sever to db") },
            error = { loge("failed insert screen sever to db") }
        )
    }

}