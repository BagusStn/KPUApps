package com.example.kpuapps.home.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kpuapps.database.DataPemilih
import com.example.kpuapps.repo.PemilihRepo

class FormEntryViewModel(application: Application) : AndroidViewModel(application) {

    private val mDataPemilihRepository: PemilihRepo = PemilihRepo(application)

    fun insert(datapemilih: DataPemilih) {
        mDataPemilihRepository.insert(datapemilih)
    }

    fun update(datapemilih: DataPemilih) {
        mDataPemilihRepository.update(datapemilih)
    }

    fun getDataPemilihByNIK(nik: String): LiveData<DataPemilih> {
        return mDataPemilihRepository.getDataPemilihByNIK(nik)
    }

    fun delete(datapemilih: DataPemilih) {
        mDataPemilihRepository.delete(datapemilih)
    }

}
