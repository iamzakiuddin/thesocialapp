package com.android.socialapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.android.socialapp.adapters.DataAdapter
import com.android.socialapp.ui.main.SectionsPagerAdapter
import com.android.socialapp.databinding.ActivitySwipeViewBinding
import com.android.socialapp.viewmodels.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SwipeView : AppCompatActivity() {

    private lateinit var binding: ActivitySwipeViewBinding
    private val dataViewModel : DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySwipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        binding.progressBar.visibility = View.VISIBLE
        dataViewModel.getUIData()
        dataViewModel.uiData.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            sectionsPagerAdapter.setUIData(it)
            viewPager.adapter = sectionsPagerAdapter
            val tabs: TabLayout = binding.tabs
            tabs.setupWithViewPager(viewPager)
        })



    }
}