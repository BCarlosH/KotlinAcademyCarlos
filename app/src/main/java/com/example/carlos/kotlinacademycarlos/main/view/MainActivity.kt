package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.common.BaseActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        addFragment(mainFragment, R.id.main_container, mainFragment.tag)
    }



    fun showSnackbar(msg: String) {
        Snackbar.make(findViewById<View>(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }

}
