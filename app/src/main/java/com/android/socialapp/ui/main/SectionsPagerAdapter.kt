package com.android.socialapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.socialapp.R
import com.android.socialapp.models.Body

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    var data: Body? = null
    override fun getItem(position: Int): Fragment {

        if (position==0){
            return PageFragment.newInstance(position,data)
        }else {
            return PageFragment.newInstance(position,data)
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }

    fun setUIData(data: Body){
        this.data = data
    }
}