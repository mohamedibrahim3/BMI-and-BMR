package com.example.bmiandbmr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

@Suppress("DEPRECATION")
class FragmentPageAdapter(fm: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fm,lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0)
            BmiFragment()
        else
            BmrFragment()
    }

}