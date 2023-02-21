package com.example.bmiandbmr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bmiandbmr.databinding.FragmentBmrBinding


class BmrFragment : Fragment() {
    private var _binding: FragmentBmrBinding? = null
    private val binding get() = _binding!!
    private var bmr: Double? = null
    private var gender: String? = null
    companion object {
        private const val ARG_BMR = "arg_bmr"
        private const val ARG_GENDER = "arg_gender"
        fun newInstance(bmr: Double, gender: String): BmrFragment {
            val args = Bundle().apply {
                putDouble(ARG_BMR, bmr)
                putString(ARG_GENDER, gender)
            }
            val fragment = BmrFragment()
            fragment.arguments = args
            return fragment

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bmr = it.getDouble(ARG_BMR, 0.0)
            gender = it.getString(ARG_GENDER)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBmrBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}