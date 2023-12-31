package com.example.happeningnow.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.happeningnow.fragments.MostViewedFragment
import com.example.happeningnow.fragments.TopStoriesFragment

private const val NUM_TABS = 2
class HomePagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TopStoriesFragment()
            1 -> return MostViewedFragment()
            else -> return TopStoriesFragment()
        }
    }
}