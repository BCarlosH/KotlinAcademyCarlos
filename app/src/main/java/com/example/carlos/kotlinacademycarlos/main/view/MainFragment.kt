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
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        initPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")

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
        val adapter = MediaAdapter(mediaItemList) { mediaItem ->
            onMediaItemClick(mediaItem)
        }
        recyclerView.adapter = adapter
    }

    /**
     * Just an error simulation here...
     */
    private fun onMediaItemClick(mediaItem: MediaItem) {
        if (resources.getString(R.string.media_item_error_simulation) == mediaItem.tittle) {
            (activity as MainActivity).showSnackBar(resources.getString(R.string.media_item_error_simulation_msg))
        } else {
            (activity as MainActivity).showDetailActivity(mediaItem.tittle, mediaItem.thumbUrl)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}