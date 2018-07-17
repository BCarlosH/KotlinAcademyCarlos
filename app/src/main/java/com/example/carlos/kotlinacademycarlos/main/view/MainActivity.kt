package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.view.View
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.carlos.kotlinacademycarlos.functionalityitem3.view.Item3Fragment
import com.example.carlos.kotlinacademycarlos.functionalityitem2.view.Item2Fragment


class MainActivity : BaseActivity() {

    private lateinit var selectedFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedFragment = MainFragment()
        addFragment(selectedFragment, R.id.main_container, selectedFragment.tag)
        setBottomNavigationBarListener()
    }

    private fun setBottomNavigationBarListener() {
        bottomNavigationBar.setOnNavigationItemSelectedListener { item: MenuItem ->

            when (item.itemId) {
                R.id.action_item1 -> if (getCurrentFragment() !is MainFragment) selectedFragment = MainFragment()
                R.id.action_item2 -> if (getCurrentFragment() !is Item2Fragment) selectedFragment = Item2Fragment()
                R.id.action_item3 -> if (getCurrentFragment() !is Item3Fragment) selectedFragment = Item3Fragment()
            }

            replaceFragment(selectedFragment, R.id.main_container, selectedFragment.tag)
            true
        }
    }

    override fun onBackPressed() {
        if (getCurrentFragment() is MainFragment) {
            super.onBackPressed()
        } else {
            bottomNavigationBar.selectedItemId = R.id.action_item1
        }
    }

    private fun getCurrentFragment(): Fragment = supportFragmentManager.findFragmentById(R.id.main_container)

    fun showSnackBar(msg: String) {
        Snackbar.make(findViewById<View>(R.id.main_activity_coordinator_layout), msg, Snackbar.LENGTH_LONG).show()
    }

}
