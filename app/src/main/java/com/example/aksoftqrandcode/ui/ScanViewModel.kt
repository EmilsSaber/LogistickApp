package com.example.aksoftqrandcode.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aksoftqrandcode.room.AppDatabase
import com.example.aksoftqrandcode.room.ScanDao
import com.example.aksoftqrandcode.room.ScanData
import kotlinx.coroutines.launch

class ScanViewModel(application: Application) : AndroidViewModel(application) {
    private val scanDao: ScanDao
    val allScans: LiveData<List<ScanData>>

    init {
        val database = AppDatabase.getInstance(application)
        scanDao = database.scanDao()
        allScans = scanDao.getAllScans()
    }

    fun insertScanData(scanData: ScanData) {
        viewModelScope.launch {
            scanDao.insert(scanData)
        }
    }
}