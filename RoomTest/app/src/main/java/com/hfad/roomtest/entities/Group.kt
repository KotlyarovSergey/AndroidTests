package com.hfad.roomtest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "groups",
    indices = [Index(value = ["group_name"], unique = true)])
data class Group(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "group_name") val name: String
)
