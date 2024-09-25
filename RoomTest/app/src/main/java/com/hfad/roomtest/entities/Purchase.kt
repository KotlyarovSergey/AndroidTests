package com.hfad.roomtest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "purchases",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(
            entity = Shop::class,
            parentColumns = ["id"],
            childColumns = ["shop_id"]
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["product_id"]
        ),
        ForeignKey(
            entity = Group::class,
            parentColumns = ["id"],
            childColumns = ["group_id"]
        )
    ]

)
data class Purchase(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val date: String,
    @ColumnInfo(name = "group_id") val groupId: Int,
    @ColumnInfo(name = "product_id") val productId: Int,
    @ColumnInfo(name = "shop_id") val shopId: Int,
    val comment: String
)