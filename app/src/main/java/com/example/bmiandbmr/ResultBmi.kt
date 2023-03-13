package com.example.bmiandbmr

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.bmiandbmr.databinding.BmiResultBinding
import kotlin.math.roundToInt

class ResultBmi : AppCompatActivity() {
    private lateinit var binding: BmiResultBinding
    private lateinit var adapter: FragmentPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BmiResultBinding.inflate(layoutInflater)

        val bmi = intent.getStringExtra("EXTRA_BMI")?.toFloat()?.roundToInt()
        val gender = intent.getStringExtra("EXTRA_GENDER")
        binding.lineBId.visibility = View.INVISIBLE
        binding.lineGId.visibility = View.INVISIBLE
        binding.lineOId.visibility = View.INVISIBLE
        binding.lineRId.visibility = View.INVISIBLE
        if(gender == "أنثى"){
            binding.womanResIdBmi.visibility = View.VISIBLE
            binding.manResIdBmi.visibility = View.INVISIBLE
        }

        if(bmi!! < 18.5){
            binding.txtResIdBmi.text = "نقص الوزن$bmi "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#1976D2"))
            binding.lineBId.visibility = View.VISIBLE
            binding.lineBId.translationX = (bmi!! * 11).toFloat()

        }
        else if (bmi!! >= 18.5 && bmi!! < 25){
            binding.txtResIdBmi.text = "وزن طبيعى$bmi "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#388E3C"))
            binding.lineGId.visibility = View.VISIBLE
            binding.lineGId.translationX = (bmi!! * 2.5).toFloat()
        }
        else if (bmi!! >= 25 && bmi!! < 30){
            binding.txtResIdBmi.text = "وزن زائد$bmi "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#FF8000"))
            binding.lineOId.visibility = View.VISIBLE
            binding.lineOId.translationX = (bmi!!-20).toFloat()
        }
        else{
            binding.txtResIdBmi.text = "سمنة زائدة$bmi "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#FF5252"))
            binding.lineRId.visibility = View.VISIBLE
            if(bmi!!>=40)
                binding.lineRId.translationX = (40*6 + 15).toFloat()
            else
                binding.lineRId.translationX = (bmi!!*3).toFloat()
        }

        setContentView(binding.root)
    }
}