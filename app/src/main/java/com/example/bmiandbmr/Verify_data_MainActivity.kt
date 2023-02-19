package com.example.bmiandbmr

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmiandbmr.databinding.ActivityVerifyDataMainBinding

class Verify_data_MainActivity : AppCompatActivity() {
    var curProgressKm = 110
    var curProgressCm = 160
    private lateinit var binding: ActivityVerifyDataMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyDataMainBinding.inflate(layoutInflater)

        binding.btnEdit.setOnClickListener {
            binding.progressBarKmr.progress = curProgressKm
            binding.progressBarCr.progress = curProgressCm
        }
        binding.btnCal.setOnClickListener {
            Intent(this,ResultBmrBmi::class.java).also {
                startActivity(it)
            }
        }
        setContentView(binding.root)
    }
}