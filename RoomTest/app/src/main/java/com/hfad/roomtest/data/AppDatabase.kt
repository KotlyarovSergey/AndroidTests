package com.hfad.roomtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hfad.roomtest.entities.Group
import com.hfad.roomtest.entities.Product
import com.hfad.roomtest.entities.Purchase
import com.hfad.roomtest.entities.Shop

@Database(
    version = 1,
    entities = [
        Group::class,
        Product::class,
        Purchase::class,
        Shop::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getGroupsDao(): GroupsDao
    abstract fun getProductsDao(): ProductsDao
    abstract fun getPurchasesDao(): PurchasesDao
    abstract fun getShopsDao(): ShopsDao
}