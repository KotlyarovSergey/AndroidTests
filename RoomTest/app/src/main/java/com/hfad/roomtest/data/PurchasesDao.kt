package com.hfad.roomtest.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hfad.roomtest.entities.Purchase
import com.hfad.roomtest.entities.PurchaseTuple

@Dao
interface PurchasesDao {
    @Query("SELECT * FROM purchases")
    suspend fun getAll(): List<Purchase>

    @Query("SELECT purchases.id, date, groups.name AS group_name, products.name AS product_name, " +
            "shops.name AS shop_name, comment FROM purchases " +
            "INNER JOIN groups ON purchases.group_id = groups.id " +
            "INNER JOIN products ON purchases.product_id = products.id " +
            "INNER JOIN shops ON purchases.shop_id = shops.id")
    suspend fun getAllAsTuple(): List<PurchaseTuple>


    @Insert
    suspend fun insert(purchase: Purchase)

    @Update
    suspend fun update(purchase: Purchase)

    @Delete
    suspend fun delete(purchase: Purchase)
}