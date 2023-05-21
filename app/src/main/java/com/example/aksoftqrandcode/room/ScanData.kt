package com.example.aksoftqrandcode.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.textfield.TextInputEditText

@Entity(tableName = "scans")
data class ScanData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val data: String,
    val name: String,
    val color: String,
    val size: String,
    val price: String,
    val artikul: String,
    val description: String,
)