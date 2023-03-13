package com.example.bmiandbmr

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import com.example.bmiandbmr.databinding.FragmentBmi2Binding
import kotlin.math.roundToInt


class BmiFragment : Fragment(R.layout.fragment_bmi2) {
    private var _binding: FragmentBmi2Binding? = null
    private val binding get() = _binding!!
    private var bmi: Double? = null
    private var gender: String? = null
    companion object {
        private const val ARG_BMI = "arg_bmi"
        private const val ARG_GENDER = "arg_gender"
        fun newInstance(bmi: Double, gender: String): BmiFragment {
            val args = Bundle().apply {
                putDouble(ARG_BMI, bmi)
                putString(ARG_GENDER, gender)
            }
            val fragment = BmiFragment()
            fragment.arguments = args
            return fragment

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bmi = it.getDouble(ARG_BMI, 0.0)
            gender = it.getString(ARG_GENDER)
        }
    }
    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBmi2Binding.inflate(inflater, container, false)
        val bmi1 = bmi!!.roundToInt()
        binding.lineBId.visibility = View.INVISIBLE
        binding.lineGId.visibility = View.INVISIBLE
        binding.lineOId.visibility = View.INVISIBLE
        binding.lineRId.visibility = View.INVISIBLE
        if(gender == "أنثى"){
            binding.womanResIdBmi.visibility = View.VISIBLE
            binding.manResIdBmi.visibility = View.INVISIBLE
        }

        if(bmi!! < 18.5){
            binding.txtResIdBmi.text = "نقص الوزن$bmi1 "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#1976D2"))
            binding.lineBId.visibility = View.VISIBLE
            binding.lineBId.translationX = (bmi!! * 11).toFloat()

        }
        else if (bmi!! >= 18.5 && bmi!! < 25){
            binding.txtResIdBmi.text = "وزن طبيعى$bmi1 "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#388E3C"))
            binding.lineGId.visibility = View.VISIBLE
            binding.lineGId.translationX = (bmi!! * 2.5).toFloat()
        }
        else if (bmi!! >= 25 && bmi!! < 30){
            binding.txtResIdBmi.text = "وزن زائد$bmi1 "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#FF8000"))
            binding.lineOId.visibility = View.VISIBLE
            binding.lineOId.translationX = (bmi!!-20).toFloat()
        }
        else{
            binding.txtResIdBmi.text = "سمنة زائدة$bmi1 "
            binding.txtResIdBmi.setTextColor(Color.parseColor("#FF5252"))
            binding.lineRId.visibility = View.VISIBLE
            if(bmi!!>=40)
                binding.lineRId.translationX = (40*6 + 15).toFloat()
            else
            binding.lineRId.translationX = (bmi!!*3).toFloat()
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}