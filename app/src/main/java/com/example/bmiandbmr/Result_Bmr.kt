package com.example.bmiandbmr

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmiandbmr.databinding.ActivityResultBmrBinding
import kotlin.math.roundToInt

class Result_Bmr : AppCompatActivity() {
    private lateinit var binding: ActivityResultBmrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBmrBinding.inflate(layoutInflater)
        val bmr = intent.getStringExtra("EXTRA_BMR")?.toFloat()?.roundToInt()
        val gender = intent.getStringExtra("EXTRA_GENDER")
        binding.idLineBlue.visibility = View.INVISIBLE
        binding.idLineGreen.visibility = View.INVISIBLE
        binding.idLineOrange.visibility = View.INVISIBLE
        binding.idLineRed.visibility = View.INVISIBLE
        binding.IdLinePurple.visibility = View.INVISIBLE
        if(gender == "أنثى"){
            binding.womanResIdBmr.visibility = View.VISIBLE
            binding.manResIdBmr.visibility = View.INVISIBLE
        }
        if(bmr!! < 1500){
            binding.txtResIdBmr.text = "للثبات علي نفس الوزن يتم استهلاك Calories/Day $bmr"
            binding.txtResIdBmr.setTextColor(Color.parseColor("#1976D2"))
            binding.idLineBlue.visibility = View.VISIBLE
            binding.idLineBlue.translationX = (5).toFloat()

        }
        else if (bmr!! >= 1500 && bmr!! < 2000){
            binding.txtResIdBmr.text = "للثبات علي نفس الوزن يتم استهلاك Calories/Day $bmr"
            binding.txtResIdBmr.setTextColor(Color.parseColor("#388E3C"))
            binding.idLineGreen.visibility = View.VISIBLE
            binding.idLineGreen.translationX = (5).toFloat()
        }
        else if (bmr!! >= 2000 && bmr!! < 2500){
            binding.txtResIdBmr.text = "للثبات علي نفس الوزن يتم استهلاك Calories/Day $bmr"
            binding.txtResIdBmr.setTextColor(Color.parseColor("#FF8000"))
            binding.idLineOrange.visibility = View.VISIBLE
            binding.idLineOrange.translationX = ("30dp").toFloat()
        }
        else if (bmr!! >= 2500 && bmr!! < 3000) {
            binding.txtResIdBmr.text = "للثبات علي نفس الوزن يتم استهلاك Calories/Day $bmr"
            binding.txtResIdBmr.setTextColor(Color.parseColor("#FF5252"))
            binding.idLineRed.visibility = View.VISIBLE
            binding.idLineRed.translationX = (bmr!! * 0.005).toFloat()
        }
        else {
            binding.txtResIdBmr.text = "للثبات علي نفس الوزن يتم استهلاك Calories/Day $bmr"
            binding.txtResIdBmr.setTextColor(Color.parseColor("#5D3891"))
            binding.IdLinePurple.visibility = View.VISIBLE
            if(bmr!!>=3500)
                binding.IdLinePurple.translationX = (bmr!! * 0.005).toFloat()
            else
                binding.IdLinePurple.translationX = (bmr!! * 0.005).toFloat()
        }
        setContentView(binding.root)
        }

    }