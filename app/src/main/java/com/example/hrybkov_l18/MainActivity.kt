package com.example.hrybkov_l18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hrybkov_l18.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupViewPager()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupViewPager() {
        val fragmentsList =
            listOf(
                DrawableFragment.newInstance(),
                BitmapFragment.newInstance(),
                GlideFragment.newInstance()
            )
        binding.viewPager.adapter = ViewPagerAdapter(this, fragmentsList)
        val tabsText = listOf(
            getString(R.string.drawable),
            getString(R.string.bitmap),
            getString(R.string.glide)
        )
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabsText[position]
        }.attach()
    }
}