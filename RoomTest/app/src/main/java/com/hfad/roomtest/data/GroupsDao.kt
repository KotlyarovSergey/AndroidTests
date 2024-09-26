package com.hfad.roomtest.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy
import com.hfad.roomtest.entities.Group

@Dao
interface GroupsDao {
    @Query("SELECT * FROM groups")
    suspend fun getAllGroups(): List<Group>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(group: Group)

//    @Query("INSERT INTO groups(name) VALUES(:groupName)")
//    suspend fun insertUnique(groupName: String)

    @Update
    suspend fun update(group: Group)

    @Delete
    suspend fun delete(group: Group)
}