package com.example.bmiandbmr

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmiandbmr.databinding.ActivityVerifyDataMainBinding

class Verify_data_MainActivity : AppCompatActivity() {
    var curProgressKm = 40
    var curProgressCm = 160
    private lateinit var binding: ActivityVerifyDataMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyDataMainBinding.inflate(layoutInflater)
        val age = intent.getStringExtra("EXTRA_AGE",)
        val height = intent.getStringExtra("EXTRA_HEIGHT")
        val weight = intent.getStringExtra("EXTRA_WEIGHT")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val cm = "$height cm"
        val kg = "$weight kg"
        val age1 = age?.toFloat()
        binding.txtCmId.text = cm
        binding.txtKgId.text = kg
        if (age1 != null) {
            binding.SliderID.value = age1.toFloat()
        }
        if(gender == "أنثى") {
            binding.imgManId.visibility = View.INVISIBLE
            binding.imgWomanId.visibility = View.VISIBLE

        }
        binding.btnEdit.setOnClickListener {
            finish()
        }
        binding.btnCal.setOnClickListener {
            Intent(this,ResultBmrBmi::class.java).also {
                startActivity(it)
            }
        }
        setContentView(binding.root)
    }
}