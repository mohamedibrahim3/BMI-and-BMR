package com.example.bmiandbmr

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bmiandbmr.databinding.ActivityResultBmrBmiBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ResultBmrBmi : AppCompatActivity() {
    private lateinit var binding: ActivityResultBmrBmiBinding
    private lateinit var adapter: FragmentPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBmrBmiBinding.inflate(layoutInflater)

        val bmi = intent.getStringExtra("EXTRA_BMI")
        val bmr = intent.getStringExtra("EXTRA_BMR")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val bmrDouble: Double = bmr!!.toDouble()
        val bmiDouble: Double = bmi!!.toDouble()
        adapter = FragmentPageAdapter(supportFragmentManager,lifecycle,bmiDouble,bmrDouble,gender)
        // Create new instances of the two fragments and pass the data to them
        val bmiFragment = BmiFragment.newInstance(bmiDouble,gender!!)
        val bmrFragment = BmrFragment.newInstance(bmrDouble,gender!!)

        // Replace the fragment containers with the new fragments
        supportFragmentManager.beginTransaction()
            .replace(R.id.viewPagerId,bmiFragment)
            .replace(R.id.viewPagerId, bmrFragment)
            .commit()
        binding.tabLayoutId.addTab(binding.tabLayoutId.newTab().setText("\t\t\t\t معدل كتله الجسم \t\t\t\t"))
        binding.tabLayoutId.addTab(binding.tabLayoutId.newTab().setText("\t\t\t\t\t معدل الحرق \t\t\t\t\t"))
        binding.viewPagerId.adapter = adapter
        binding.tabLayoutId.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPagerId.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        binding.viewPagerId.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayoutId.selectTab(binding.tabLayoutId.getTabAt(position))
            }
        })
        setContentView(binding.root)
    }
}