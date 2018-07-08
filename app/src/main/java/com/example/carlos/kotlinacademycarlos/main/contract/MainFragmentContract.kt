package com.example.carlos.kotlinacademycarlos.main.contract

import com.example.carlos.kotlinacademycarlos.common.BaseContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

interface MainFragmentContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData(): List<MediaItem>
    }

}