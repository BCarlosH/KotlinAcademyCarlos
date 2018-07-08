package com.example.carlos.kotlinacademycarlos.main.presenter

import com.example.carlos.kotlinacademycarlos.common.dummyAltMainListData
import com.example.carlos.kotlinacademycarlos.main.contract.MainFragmentContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

class MainFragmentPresenter : MainFragmentContract.Presenter {

    private lateinit var view: MainFragmentContract.View


    override fun attach(view: MainFragmentContract.View) {
        this.view = view
    }

    override fun loadData(): List<MediaItem> = dummyAltMainListData()

}