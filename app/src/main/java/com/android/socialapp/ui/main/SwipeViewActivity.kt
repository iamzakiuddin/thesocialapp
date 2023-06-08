package com.android.socialapp.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.android.socialapp.ui.main.SectionsPagerAdapter
import com.android.socialapp.databinding.ActivitySwipeViewBinding
import com.android.socialapp.network.NetworkResponse
import com.android.socialapp.viewmodels.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SwipeViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySwipeViewBinding
    private val dataViewModel : DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySwipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        dataViewModel.getUIData()
        dataViewModel.uiData.observe(this) { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is NetworkResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    if (result?.data!=null)
                    sectionsPagerAdapter.setUIData(result.data)
                    viewPager.adapter = sectionsPagerAdapter
                    val tabs: TabLayout = binding.tabs
                    tabs.setupWithViewPager(viewPager)
                }
                is NetworkResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    Toast.makeText(this@SwipeViewActivity,result.message,Toast.LENGTH_SHORT).show()
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    Toast.makeText(this@SwipeViewActivity,"Something went wrong!",Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            dataViewModel.getFreshUIData()
        }
    }
}