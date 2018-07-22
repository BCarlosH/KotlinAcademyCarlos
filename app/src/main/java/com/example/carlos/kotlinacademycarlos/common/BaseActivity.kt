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

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, backStackTag: String?, addToBackStack: Boolean) {
        supportFragmentManager.inTransaction {
            add(frameId, fragment, backStackTag)
            if (addToBackStack) backStackTag?.let { addToBackStack(fragment.javaClass.name) }
        }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, backStackTag: String?, addToBackStack: Boolean) {
        supportFragmentManager.inTransaction {
            replace(frameId, fragment, backStackTag)
            if (addToBackStack) backStackTag?.let { addToBackStack(fragment.javaClass.name) }
        }
    }

    fun switchFragments(fragmentTag: String, layoutContainerId: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.detach(getCurrentFragment(layoutContainerId))
        fragmentTransaction.attach(supportFragmentManager.findFragmentByTag(fragmentTag))
        fragmentTransaction.commit()
    }

    fun detachCurrentFragment(layoutContainerId: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.detach(getCurrentFragment(layoutContainerId))
        fragmentTransaction.commit()
    }

    fun getCurrentFragment(layoutContainerId: Int): Fragment = supportFragmentManager.findFragmentById(layoutContainerId)

}