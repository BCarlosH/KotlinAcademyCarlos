package com.example.carlos.kotlinacademycarlos.functionalityitem3.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlos.kotlinacademycarlos.R

class Item3Fragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_item3, container, false)
    }
}