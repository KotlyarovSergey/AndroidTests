package com.hfad.roomtest.entities

import androidx.room.ColumnInfo

data class PurchaseTuple(
    val id: Long,
    val date: String,
    @ColumnInfo(name = "group_name") val group: String,
    @ColumnInfo(name = "product_name") val product: String,
    @ColumnInfo(name = "shop_name") val shop: String,
    val comment: String
)

data class PurchaseTupleTest(
    val id: Long,
    val date: String,
    @ColumnInfo(name = "group_name") val group: String
)