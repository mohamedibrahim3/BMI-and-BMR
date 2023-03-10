package com.example.bmiandbmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bmiandbmr.databinding.ActivityVerifyDataMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

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
        val y = "$age age"
        val age1 = age?.toFloat()
        val height1 = height?.toFloat()
        val weight1 = weight?.toFloat()
        binding.txtCmId.text = cm
        binding.txtKgId.text = kg
        binding.txtAgeId?.text = y
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
            val view: View = layoutInflater.inflate(R.layout.bottom_sheet_to_calculate_bmi_bmr, null)
            val dialog = BottomSheetDialog(this)
            val BtnIdBmi = view.findViewById<Button>(R.id.btnIdCalcBmi)
            val BtnIdBmr = view.findViewById<Button>(R.id.btnIdCalcBmr)
            BtnIdBmi.setOnClickListener {
                Intent(this,ResultBmi::class.java).also {
                    it.putExtra("EXTRA_BMI",bmiS)
                    it.putExtra("EXTRA_GENDER",gender)
                    startActivity(it)
                }
            }
            BtnIdBmr.setOnClickListener {
                Intent(this,Result_Bmr::class.java).also {
                    it.putExtra("EXTRA_BMR",bmrS)
                    it.putExtra("EXTRA_GENDER",gender)
                    startActivity(it)
                }
            }

            dialog.setContentView(view)
            dialog.show()
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