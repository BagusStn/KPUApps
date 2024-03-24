package com.example.kpuapps.home.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kpuapps.databinding.ActivityDaftarpemilihBinding
import com.example.kpuapps.helper.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class DaftarPemilih : AppCompatActivity() {

    private var _daftarDataPemilihBinding: ActivityDaftarpemilihBinding? = null
    private val binding get() = _daftarDataPemilihBinding

    private lateinit var adapter: PemilihAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _daftarDataPemilihBinding = ActivityDaftarpemilihBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.title = "Daftar Data Pemilih"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val daftarDataPemilihViewModel = obtainViewModel(this@DaftarPemilih)

        daftarDataPemilihViewModel.getAllDataPemilih().observe(this) { datapemilihList ->
            if (datapemilihList != null && datapemilihList.isNotEmpty()) {
                adapter.setListDataPemilih(datapemilihList)
            } else {
                adapter.setListDataPemilih(emptyList())
                showNoDataSnackbar()
            }
        }

        adapter = PemilihAdapter()

        binding?.rvDatapemilih?.layoutManager = LinearLayoutManager(this)
        binding?.rvDatapemilih?.setHasFixedSize(true)
        binding?.rvDatapemilih?.adapter = adapter

    }

    private fun showNoDataSnackbar() {
        val snackbar = Snackbar.make(
            binding?.root!!,
            "Tidak ada data saat ini",
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }

    private fun obtainViewModel(activity: AppCompatActivity): DaftarPemilihViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(DaftarPemilihViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _daftarDataPemilihBinding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}