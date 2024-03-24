package com.example.kpuapps.home.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kpuapps.database.DataPemilih
import com.example.kpuapps.repo.PemilihRepo

class DaftarPemilihViewModel(application: Application) : ViewModel() {

    private val mDataPemilihRepository: PemilihRepo = PemilihRepo(application)

    fun getAllDataPemilih(): LiveData<List<DataPemilih>> =
        mDataPemilihRepository.getAllDataPemilih()
}