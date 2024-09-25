package com.hfad.roomtest

import android.content.Context
import androidx.room.Room
import com.hfad.roomtest.data.AppDatabase

object Dependencies {
    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy{
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .build()
    }
}