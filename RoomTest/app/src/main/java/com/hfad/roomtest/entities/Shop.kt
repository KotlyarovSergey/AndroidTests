package com.hfad.roomtest.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "shops",
    indices = [Index(value = ["name"], unique = true)])
data class Shop(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)
