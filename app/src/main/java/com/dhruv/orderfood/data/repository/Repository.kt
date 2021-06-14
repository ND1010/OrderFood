package com.dhruv.orderfood.data.repository

import com.dhruv.orderfood.data.models.*
import com.dhruv.orderfood.data.models.login_master.LoginResponse
import com.dhruv.orderfood.utils.base.Resource
import io.reactivex.Observable

interface Repository {
    fun getIsLogin(): Boolean
    fun setIsLogin(isLogin: Boolean)
    fun getId(): String?
    fun setId(id: String)

    fun insertScreenSever(list: List<ScreenSaverMaster>)
    fun insertCategoryMasters(list: List<CategoryMaster>)
    fun insertCategoryImage(list: List<CategoryImage>)
    fun insertItems(list: List<Item>)
    fun insertItemImages(list: List<ItemImage>)
    fun insertItemCategoryMapping(list: List<ItemCategoryMapping>)
    fun getAllCategory(): Observable<List<CategoryRaw>>
    fun getAllItem(): Observable<List<ItemWithImage>>
    fun getScreenSaver(): Observable<List<ScreenSaverMaster>>
//    fun getItemListFromCategory(cat_id:Int): Observable<List<ProductItem>>

    suspend fun doLogin(loginRequest: LoginRequest): Resource<LoginResponse>
}