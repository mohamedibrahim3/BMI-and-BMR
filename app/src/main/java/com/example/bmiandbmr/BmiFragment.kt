package com.example.bmiandbmr

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bmiandbmr.databinding.FragmentBmi2Binding


class BmiFragment : Fragment() {
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
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBmi2Binding.inflate(inflater, container, false)
        binding.txtResIdBmi.text = "وزن طبيعي$bmi"
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}