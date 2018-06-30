package com.example.carlos.kotlinacademycarlos.common

interface BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {
        fun initPresenter()
    }
}