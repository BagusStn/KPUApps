package com.example.kpuapps.home.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kpuapps.databinding.ActivityMainBinding
import com.example.kpuapps.home.add.FormEntry

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInformasi.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        binding.buttonFormEntry.setOnClickListener {
            val intent = Intent(this, FormEntry::class.java)
            startActivity(intent)
        }

        binding.buttonLihatData.setOnClickListener {
            val intent = Intent(this, DaftarPemilih::class.java)
            startActivity(intent)
        }

        binding.buttonKeluar.setOnClickListener {
            finish()
        }
    }
}