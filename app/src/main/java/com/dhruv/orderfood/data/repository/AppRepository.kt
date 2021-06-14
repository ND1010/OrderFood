package com.dhruv.orderfood.data.repository

import com.dhruv.orderfood.data.db.LocalDataSource
import com.dhruv.orderfood.data.models.*
import com.dhruv.orderfood.data.models.login_master.LoginResponse
import com.dhruv.orderfood.data.pref.PrefDataSource
import com.dhruv.orderfood.utils.base.Resource
import io.reactivex.Observable

open class AppRepository constructor(
    private val db: LocalDataSource,
    private val pref: PrefDataSource,
    private val remoteRepo: RemoteDataSource
) : Repository {

    override fun getIsLogin(): Boolean = pref.getIsLogin()
    override fun setIsLogin(isLogin: Boolean) = pref.setIsLogin(isLogin)
    override fun getId(): String? = pref.getId()
    override fun setId(id: String) = pref.setId(id)

    override fun insertScreenSever(list: List<ScreenSaverMaster>)= db.insertScreenSever(list)
    override fun insertCategoryImage(list: List<CategoryImage>)  = db.insertCategoryItem(list)
    override fun insertCategoryMasters(list: List<CategoryMaster>) = db.insertCategoryMaster(list)
    override fun insertItemCategoryMapping(list: List<ItemCategoryMapping>) = db.insertItemCategoryMapping(list)
    override fun insertItemImages(list: List<ItemImage>) = db.insertItemImage(list)
    override fun insertItems(list: List<Item>)  = db.insertItem(list)
    override fun getAllCategory(): Observable<List<CategoryRaw>> = db.getAllCategory()
    override fun getAllItem(): Observable<List<ItemWithImage>> = db.getAllItem()
    override fun getScreenSaver(): Observable<List<ScreenSaverMaster>> = db.getScreenSaver()
    //override fun getItemListFromCategory(cat_id:Int): Observable<List<ProductItem>> = db.getAllItemListFromCat(cat_id)

    override suspend fun doLogin(loginRequest: LoginRequest): Resource<LoginResponse> = remoteRepo.apiLogin(loginRequest)
}