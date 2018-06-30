package com.example.carlos.kotlinacademycarlos.main.contract

import com.example.carlos.kotlinacademycarlos.common.BaseContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

interface MainActivityContract {

    interface View : BaseContract.View {
        fun showSnackbar(msg: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData(): List<MediaItem>
    }

}