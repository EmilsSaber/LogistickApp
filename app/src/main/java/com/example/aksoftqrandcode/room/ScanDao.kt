package com.example.aksoftqrandcode.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScanDao {
    @Insert
    suspend fun insert(scanData: ScanData)

    @Query("SELECT * FROM scans")
    fun getAllScans(): LiveData<List<ScanData>>
}