package com.delaware.data.sherpa

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.home_app_bar.*
import kotlinx.android.synthetic.main.home_content.*

import com.delaware.data.sherpa.SearchFragment.OnButtonClickedListenter
import com.delaware.data.sherpa.advancedsearch.AdvancedSearch

class HomeActivity : AppCompatActivity(), OnNavigationItemSelectedListener, OnButtonClickedListenter {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var fragment: Fragment? = null

        //switching fragments on the home screen
        when (item.itemId) {
            R.id.navigation_learn -> fragment = LearnFragment()
            R.id.navigation_search -> fragment = SearchFragment()
            R.id.navigation_apply -> fragment = ApplyFragment()
        }

        return@OnNavigationItemSelectedListener loadFragment(fragment)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Sherpa_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)

        toggle.syncState()

        drawer_navigation_view.setNavigationItemSelectedListener(this)

        //loading the default fragment
        loadFragment(LearnFragment())

        //initializing the bottom navigation
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.app_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.settings_option -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment!!)
                .commit()
            return true
        }
        return false
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onButtonClicked(){
        val intent =  Intent(this, AdvancedSearch::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
