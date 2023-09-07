package com.example.happeningnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happeningnow.adapters.HomePagerAdapter
import com.example.happeningnow.databinding.ActivityMainBinding
import com.example.happeningnow.ui.theme.HappeningNowTheme
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = HomePagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val animalsArray = arrayOf(
            getString(R.string.tab_top_stories),
            getString(R.string.tab_most_viewed)
        )

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()
    }
}

