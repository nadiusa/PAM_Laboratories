package com.sample.app.tabs_screens.tabs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.R
import com.sample.app.tabs_screens.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_tabs.*


class TabsActivity : AppCompatActivity() {

    private val pagerAdapter: ViewPagerAdapter =
        ViewPagerAdapter(this.supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setSupportActionBar(toolbar)

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }
}
