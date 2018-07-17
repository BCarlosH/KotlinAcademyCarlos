package com.example.carlos.kotlinacademycarlos.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, backStackTag: String? = null) {
        supportFragmentManager.inTransaction {
            add(frameId, fragment)
            backStackTag?.let { addToBackStack(fragment.javaClass.name) }
        }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, backStackTag: String? = null) {
        supportFragmentManager.inTransaction {
            replace(frameId, fragment)
            backStackTag?.let { addToBackStack(fragment.javaClass.name) }
        }
    }
}