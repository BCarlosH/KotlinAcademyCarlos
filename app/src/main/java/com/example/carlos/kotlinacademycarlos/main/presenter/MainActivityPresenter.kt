package com.example.carlos.kotlinacademycarlos.main.presenter

import com.example.carlos.kotlinacademycarlos.common.dummyAltMainListData
import com.example.carlos.kotlinacademycarlos.common.dummyMainListData
import com.example.carlos.kotlinacademycarlos.main.contract.MainActivityContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

class MainActivityPresenter : MainActivityContract.Presenter {

    private lateinit var view: MainActivityContract.View


    override fun attach(view: MainActivityContract.View) {
        this.view = view
    }

    override fun loadData(): List<MediaItem> = dummyAltMainListData()

}