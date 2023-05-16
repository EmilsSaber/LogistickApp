package com.example.aksoftqrandcode.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "scans")
data class ScanData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val data: String
)