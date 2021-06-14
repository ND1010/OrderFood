package com.dhruv.orderfood.data.db

import androidx.room.*
import com.dhruv.orderfood.data.models.*
import io.reactivex.Observable

@Dao
interface ScreenSeverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllScreenSever(screenSever: List<ScreenSaverMaster>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCategoryImage(screenSever: List<CategoryImage>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCategoryMaster(list: List<CategoryMaster>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllItemCategoryMapping(list: List<ItemCategoryMapping>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllItemImage(list: List<ItemImage>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertitem(list: List<Item>)

    @get:Query("SELECT * FROM screen_saver_master")
    val all: Observable<List<ScreenSaverMaster>>

    @Transaction
    @Query("SELECT * FROM category_master")
    fun allCategory(): Observable<List<CategoryRaw>>

    @Transaction
    @Query("SELECT * FROM item")
    fun allItem(): Observable<List<ItemWithImage>>


    /*@Transaction
    @Query("SELECT * from item_category_mapping ic inner join item i on ic.ItemID = i.ItemID inner join item_image im on im.ItemID = i.ItemID where ic.categoryID=:cat_id")
    fun allItemList(cat_id: Int): Observable<List<ProductItem>>*/

}