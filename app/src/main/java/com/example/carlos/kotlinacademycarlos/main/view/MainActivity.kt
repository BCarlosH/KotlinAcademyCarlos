package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.carlos.kotlinacademycarlos.functionalityitem3.view.Item3Fragment
import com.example.carlos.kotlinacademycarlos.functionalityitem2.view.Item2Fragment


private const val ARG_ITEM_SELECTED = "itemSelected"
private const val ARG_ITEM_IMAGE = "itemImage"

private const val MAIN_FRAGMENT_TAG = "main_fragment_tag"
private const val ITEM2_FRAGMENT_TAG = "item2_fragment_tag"
private const val ITEM3_FRAGMENT_TAG = "item3_fragment_tag"


class MainActivity : BaseActivity() {

    private val TAG = MainActivity::class.java.name


    private lateinit var selectedFragment: Fragment
    private var layoutContainerId: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        setContentView(R.layout.activity_main)
        layoutContainerId = R.id.main_container

        selectedFragment = MainFragment()
        addFragment(selectedFragment, R.id.main_container, MAIN_FRAGMENT_TAG, false)
        setBottomNavigationBarListener()
    }

    private fun setBottomNavigationBarListener() {
        bottomNavigationBar.setOnNavigationItemSelectedListener { item: MenuItem ->
            manageBottomNavigationBarNavigation(item)
            true
        }
    }

    private fun manageBottomNavigationBarNavigation(itemSelected: MenuItem) {
        when (itemSelected.itemId) {

            R.id.action_item1 -> if (getCurrentFragment(layoutContainerId) !is MainFragment) {
                if (supportFragmentManager.findFragmentByTag(MAIN_FRAGMENT_TAG) == null) {

                    detachCurrentFragment(layoutContainerId)
                    selectedFragment = MainFragment()
                    addFragment(selectedFragment, layoutContainerId, MAIN_FRAGMENT_TAG, false)

                } else {
                    switchFragments(MAIN_FRAGMENT_TAG, layoutContainerId)
                }
            }

            R.id.action_item2 -> if (getCurrentFragment(layoutContainerId) !is Item2Fragment) {
                if (supportFragmentManager.findFragmentByTag(ITEM2_FRAGMENT_TAG) == null) {

                    detachCurrentFragment(layoutContainerId)
                    selectedFragment = Item2Fragment()
                    addFragment(selectedFragment, layoutContainerId, ITEM2_FRAGMENT_TAG, false)

                } else {
                    switchFragments(ITEM2_FRAGMENT_TAG, layoutContainerId)
                }
            }

            R.id.action_item3 -> if (getCurrentFragment(layoutContainerId) !is Item3Fragment) {
                if (supportFragmentManager.findFragmentByTag(ITEM3_FRAGMENT_TAG) == null) {

                    detachCurrentFragment(layoutContainerId)
                    selectedFragment = Item3Fragment()
                    addFragment(selectedFragment, layoutContainerId, ITEM3_FRAGMENT_TAG, false)

                } else {
                    switchFragments(ITEM3_FRAGMENT_TAG, layoutContainerId)
                }
            }

        }
    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed")
        if (getCurrentFragment(layoutContainerId) is MainFragment) {
            super.onBackPressed()
        } else if (getCurrentFragment(layoutContainerId) is DetailFragment) {
            setBottomNavigationBarVisibility(true)
            bottomNavigationBar.selectedItemId = R.id.action_item1
        } else {
            bottomNavigationBar.selectedItemId = R.id.action_item1
        }
    }

    fun showDetailActivity(itemSelected: String, thumbUrl: String) {
        startActivity(detailIntent(itemSelected, thumbUrl))
    }

    fun showDetailFragment(itemSelected: String, thumbUrl: String) {
        val detailFragment = DetailFragment()
        val arguments = Bundle()
        arguments.putString(ARG_ITEM_SELECTED, itemSelected)
        arguments.putString(ARG_ITEM_IMAGE, thumbUrl)
        detailFragment.arguments = arguments
        replaceFragment(detailFragment, layoutContainerId, null, false)

        setBottomNavigationBarVisibility(false)
    }

    private fun setBottomNavigationBarVisibility(visible: Boolean) {
        if (visible) bottomNavigationBar.visibility = View.VISIBLE else bottomNavigationBar.visibility = View.GONE
    }

    fun showSnackBar(msg: String) {
        Snackbar.make(findViewById<View>(R.id.main_activity_coordinator_layout), msg, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}
