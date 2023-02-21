package com.example.bmiandbmr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

@Suppress("DEPRECATION")
class FragmentPageAdapter(fm: FragmentManager,lifecycle: Lifecycle,private val bmi: Double, private val bmr: Double, private val gender: String?):

    FragmentStateAdapter(fm,lifecycle){
    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BmiFragment.newInstance(bmi, gender!!)
            1 -> BmrFragment.newInstance(bmr, gender!!)
            else -> throw IllegalArgumentException("Invalid position")
        }
    }


}