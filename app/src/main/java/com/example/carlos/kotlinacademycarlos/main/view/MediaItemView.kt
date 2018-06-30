package com.example.carlos.kotlinacademycarlos.main.view

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_media_item.view.*

class MediaItemView(itemView: View, private val itemClick: (MediaItem) -> Unit) : ViewHolder(itemView) {


    private val tvItemTittle = itemView.itemTittle
    private val imgItemThumb = itemView.itemThumbImage


    fun bind(item: MediaItem) {
        tvItemTittle.text = item.tittle

        Picasso.get()
                .load(item.thumbUrl)
                .error(R.drawable.explosion)
                .placeholder(R.drawable.loader_animation)
                .into(imgItemThumb)

        itemView.setOnClickListener { itemClick(item) }
    }

}