package com.example.carlos.kotlinacademycarlos.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.carlos.kotlinacademycarlos.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

private const val ARG_ITEM_SELECTED = "itemSelected"
private const val ARG_ITEM_IMAGE = "itemImage"

class DetailFragment : Fragment() {

    private val TAG = DetailFragment::class.java.name

    private var itemSelected: String? = null
    private var itemImage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemSelected = it.getString(ARG_ITEM_SELECTED)
            itemImage = it.getString(ARG_ITEM_IMAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        detailHeader.text = itemSelected

        Picasso.get()
                .load(itemImage)
                .error(R.drawable.explosion)
                .placeholder(R.drawable.loader_animation)
                .into(itemImageView)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}
