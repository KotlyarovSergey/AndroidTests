package com.hfad.roomtest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "groups",
    indices = [Index(value = ["name"], unique = true)])
data class Group(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
