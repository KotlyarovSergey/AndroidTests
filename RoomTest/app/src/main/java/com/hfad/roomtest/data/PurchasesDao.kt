package com.hfad.roomtest.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hfad.roomtest.entities.Purchase
import com.hfad.roomtest.entities.PurchaseTupleTest

@Dao
interface PurchasesDao {
    @Query("SELECT * FROM purchases")
    suspend fun getAll(): List<Purchase>

    @Query("SELECT purchases.id, date, group_name FROM purchases \n" +
            "INNER JOIN groups ON purchases.group_id = groups.id")
    suspend fun getAllAsTuple(): List<PurchaseTupleTest>


    @Insert
    suspend fun insert(purchase: Purchase)

    @Update
    suspend fun update(purchase: Purchase)

    @Delete
    suspend fun delete(purchase: Purchase)
}