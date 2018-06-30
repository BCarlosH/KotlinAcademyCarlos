package com.example.carlos.kotlinacademycarlos.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.main.contract.MainActivityContract
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem
import com.example.carlos.kotlinacademycarlos.main.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var presenter: MainActivityContract.Presenter
    private lateinit var mediaItemList: List<MediaItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        loadData()
        initAdapter()
        setGreetingButtonListener()
    }
    
    override fun initPresenter() {
        presenter = MainActivityPresenter()
        presenter.attach(this)
    }

    private fun loadData() {
        mediaItemList = presenter.loadData()
    }

    private fun initAdapter() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = MediaAdapter(mediaItemList) { mediaItem -> showSnackbar(mediaItem.tittle) }
        recyclerView.adapter = adapter
    }

    private fun setGreetingButtonListener() {
        bShowMessage.setOnClickListener {
            etMessage.clearFocus()
            if (etMessage.text.isNotEmpty()) showSnackbar(String.format(getString(R.string.hello_msg), etMessage.text))
        }
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(findViewById<View>(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }

}
