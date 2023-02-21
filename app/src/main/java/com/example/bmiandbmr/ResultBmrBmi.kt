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

        adapter = FragmentPageAdapter(supportFragmentManager,lifecycle)

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