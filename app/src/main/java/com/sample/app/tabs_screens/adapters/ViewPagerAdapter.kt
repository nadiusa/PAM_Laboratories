package com.sample.app.tabs_screens.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sample.app.tabs.fragments.PlayingNow
import com.sample.app.tabs.fragments.SimilarMovies


class ViewPagerAdapter(fragmentManager: FragmentManager):
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles: Array<String> = arrayOf(
        "Similar Movies",
        "Playing Now"
    )

    private val pagerFragments: Array<Fragment> = arrayOf(
        SimilarMovies(),
        PlayingNow()
    )

    override fun getItem(position: Int): Fragment {
        return pagerFragments[position]
    }

    override fun getCount(): Int {
        return pagerFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}