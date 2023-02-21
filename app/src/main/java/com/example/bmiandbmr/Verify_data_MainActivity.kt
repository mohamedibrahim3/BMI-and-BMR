package com.example.bmiandbmr

import android.content.Intent
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
        val height1 = height?.toFloat()
        val weight1 = weight?.toFloat()
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
            val bmr = calcBMR(age1,height1,weight1,gender)
            val bmi = calcBMI(height1,weight1)
            val bmrS: String = bmr.toString()
            val bmiS: String = bmi.toString()
            Intent(this,ResultBmrBmi::class.java).also {
                it.putExtra("EXTRA_BMR",bmrS)
                it.putExtra("EXTRA_BMI",bmiS)
                it.putExtra("EXTRA_GENDER",gender)
                startActivity(it)
            }
        }

        setContentView(binding.root)
    }
    fun calcBMR(age: Float?, height: Float?, weight: Float?, gender: String?) : Double {
        return if(gender != "أنثى")
            88.362 + (13.397 * weight!!) + (4.799 * height!!) - (5.677 * age!!)
        else
            447.593  + (9.247 * weight!!) + (3.098 * height!!) - (4.330 * age!! )
    }
    fun calcBMI(height: Float?, weight: Float?) : Float {
        return (weight!!/((height!!/100)*(height /100)))
    }
}