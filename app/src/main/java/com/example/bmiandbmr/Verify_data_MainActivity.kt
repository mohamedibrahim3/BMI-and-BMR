package com.example.bmiandbmr

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmiandbmr.databinding.ActivityVerifyDataMainBinding

class Verify_data_MainActivity : AppCompatActivity() {
    var curProgressKm = 40
    var curProgressCm = 130
    private lateinit var binding: ActivityVerifyDataMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyDataMainBinding.inflate(layoutInflater)
        binding.btnEdit.setOnClickListener {
            val layoutParams = binding.imgWomanId.layoutParams
            layoutParams.height = 160
            binding.imgWomanId.layoutParams = layoutParams
            binding.progressBarKmr.progress = curProgressKm
            binding.progressBarCr.progress = curProgressCm + 2
        }
        binding.btnCal.setOnClickListener {
            Intent(this,ResultBmrBmi::class.java).also {
                startActivity(it)
            }
        }
        setContentView(binding.root)
    }
}