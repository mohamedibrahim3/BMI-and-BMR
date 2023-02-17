package com.example.bmiandbmr

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.bmiandbmr.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        forBindingId()
        forLetId()
        val gender = resources.getStringArray(R.array.Gender)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_items,gender)
        binding?.genderAutoComplete?.setAdapter(arrayAdapter)

        binding?.NextBtntInBMI?.setOnClickListener {
            bindingIsEmpty()
        }
        setContentView(binding?.root)
    }


    private fun setHint(view: TextInputEditText, string: Int) {
        view.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                view.hint = ""
                (v as TextInputEditText).gravity = Gravity.RIGHT
            } else {
                if (view.text?.isEmpty() == true) {
                    view.hint = getString(string)
                    (v as TextInputEditText).gravity = Gravity.RIGHT
                }
            }
        }
    }
    private fun forBindingId(){
        binding?.ageEditText?.inputType = InputType.TYPE_CLASS_NUMBER
        binding?.heightEditText?.inputType = InputType.TYPE_CLASS_NUMBER
        binding?.weightEditText?.inputType = InputType.TYPE_CLASS_NUMBER
        binding?.ageEditText?.hint = getString(R.string.YourAge)
        binding?.heightEditText?.hint = getString(R.string.CM)
        binding?.weightEditText?.hint = getString(R.string.KM)
    }
    private fun forLetId(){
        binding?.ageEditText?.let {
            setHint(it, R.string.YourAge)
        }
        binding?.heightEditText?.let {
            setHint(it, R.string.CM)
        }
        binding?.weightEditText?.let {
            setHint(it, R.string.KM)
        }
    }
    private fun bindingIsEmpty(){
        if(binding?.ageEditText?.text?.isEmpty() == true) {
            binding?.Star1?.visibility = View.VISIBLE
            binding?.Star1?.setTextColor(Color.parseColor("#EB1D36"))
        }
        else if (binding?.ageEditText?.text?.isEmpty() != true){
            binding?.Star1?.visibility = View.INVISIBLE
            binding?.AgeInputLayout?.boxStrokeColor = resources.getColor(R.color.light_blue1)
        }
        if(binding?.heightEditText?.text?.isEmpty() == true) {
            binding?.Star2?.visibility = View.VISIBLE
            binding?.Star2?.setTextColor(Color.parseColor("#EB1D36"))
        }
        else if (binding?.heightEditText?.text?.isEmpty() != true){
            binding?.Star2?.visibility = View.INVISIBLE
            binding?.HeightInputLayout?.boxStrokeColor = resources.getColor(R.color.light_blue1)

        }
        if(binding?.weightEditText?.text?.isEmpty() == true) {
            binding?.Star3?.visibility = View.VISIBLE
            binding?.Star3?.setTextColor(Color.parseColor("#EB1D36"))
        }
        else if (binding?.weightEditText?.text?.isEmpty() != true){
            binding?.Star3?.visibility = View.INVISIBLE
            binding?.WeightInputLayout?.boxStrokeColor = resources.getColor(R.color.light_blue1)

        }

    }
}