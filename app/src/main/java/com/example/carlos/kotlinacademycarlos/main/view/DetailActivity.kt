package com.example.carlos.kotlinacademycarlos.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.common.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*


private const val INTENT_ITEM_SELECTED = "itemSelected"
private const val INTENT_ITEM_IMAGE = "itemImage"

fun Context.detailIntent(itemSelected: String, itemImage: String): Intent {
    return Intent(this, DetailActivity::class.java).apply {
        putExtra(INTENT_ITEM_SELECTED, itemSelected)
        putExtra(INTENT_ITEM_IMAGE, itemImage)
    }
}


class DetailActivity : BaseActivity() {

    private val TAG = DetailActivity::class.java.name

    private var itemSelected: String? = null
    private var itemImage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        itemSelected = intent.getStringExtra(INTENT_ITEM_SELECTED)
        itemImage = intent.getStringExtra(INTENT_ITEM_IMAGE)
    }

    override fun onStart() {
        super.onStart()

        detailHeader.text = itemSelected

        Picasso.get()
                .load(itemImage)
                .error(R.drawable.explosion)
                .placeholder(R.drawable.loader_animation)
                .into(itemImageView)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(TAG, "onBackPressed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

}



