package com.delaware.data.sherpa.advancedsearch

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.delaware.data.sherpa.R

class AdvancedSearch: AppCompatActivity(){

    val LOG_TAG = this.javaClass.simpleName
    var options: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "Activity Started")
        setContentView(R.layout.advanced_search_layout)

        options = resources.getStringArray(R.array.advanced_search_options)

        val mPagerAdapter = CoursePagerAdapter(supportFragmentManager, this)

        val mViewPager = findViewById<ViewPager>(R.id.pager)
        mViewPager.adapter = mPagerAdapter
        mViewPager.currentItem = 0

        val mSlidingTabLayout = findViewById<SlidingTabLayout>(R.id.sliding_tabs)
        mSlidingTabLayout.setViewPager(mViewPager)
        mSlidingTabLayout.setCustomTabColorizer(object : SlidingTabLayout.TabColorizer {

            override fun getIndicatorColor(position: Int): Int {
                return Color.argb(255, 128, 203, 196)
            }

            override fun getDividerColor(position: Int): Int {
                return Color.GRAY
            }
        })
    }

    internal inner class CoursePagerAdapter(fm: FragmentManager, var context: Context) : FragmentPagerAdapter(fm) {

        override fun getItem(i: Int): Fragment {
            return Section.newInstance(options!![i])
        }

        override fun getCount(): Int {
            return options!!.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            Log.d(LOG_TAG, options!![position])
            return options!![position]
        }
    }


    class Section : Fragment() {

        val SECTION = "SECTION"

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.holder_view, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            view.findViewById<TextView>(R.id.holderView).setText(arguments!!.getString(SECTION))
        }

        companion object {

            val SECTION = "SECTION"

            fun newInstance(section: String): Section {
                val fragment = Section()
                val args = Bundle()
                args.putString(SECTION, section)
                fragment.arguments = args
                return fragment
            }
        }
    }
}