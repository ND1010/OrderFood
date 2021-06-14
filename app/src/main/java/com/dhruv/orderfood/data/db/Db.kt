package com.dhruv.orderfood.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhruv.orderfood.data.models.*


@Database(
    entities = [ScreenSaverMaster::class, Item::class, ItemImage::class, CategoryImage::class, CategoryMaster::class,
        ItemCategoryMapping::class],
    version = 1, exportSchema = false
)
abstract class Db : RoomDatabase() {

    // --- DAO ---
    abstract fun screenServerDao(): ScreenSeverDao

    companion object {

        // --- SINGLETON ---
        @Volatile
        private var INSTANCE: Db? = null

        fun getInstance(context: Context): Db {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "bike_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}