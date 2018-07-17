package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.main.contract.MainFragmentContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem
import com.example.carlos.kotlinacademycarlos.main.presenter.MainFragmentPresenter
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), MainFragmentContract.View {

    private lateinit var presenter: MainFragmentContract.Presenter
    private lateinit var mediaItemList: List<MediaItem>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPresenter()
        loadData()
        initAdapter()

        (activity as MainActivity).showSnackBar("Item 1 created")
    }

    override fun initPresenter() {
        presenter = MainFragmentPresenter()
        presenter.attach(this)
    }

    private fun loadData() {
        mediaItemList = presenter.loadData()
    }

    private fun initAdapter() {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        val adapter = MediaAdapter(mediaItemList) { mediaItem -> (activity as MainActivity).showSnackBar(mediaItem.tittle) }
        recyclerView.adapter = adapter
    }

}