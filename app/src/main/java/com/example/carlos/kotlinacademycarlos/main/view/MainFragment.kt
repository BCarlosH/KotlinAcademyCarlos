package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.main.contract.MainFragmentContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem
import com.example.carlos.kotlinacademycarlos.main.presenter.MainFragmentPresenter
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), MainFragmentContract.View {

    private val TAG = MainFragment::class.java.name

    private lateinit var presenter: MainFragmentContract.Presenter
    private lateinit var mediaItemList: List<MediaItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)

        initPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        loadData()
        initAdapter()
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
        val adapter = MediaAdapter(mediaItemList) { mediaItem -> (activity as MainActivity)
                .showDetailFragment(mediaItem.tittle, mediaItem.thumbUrl) }
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}