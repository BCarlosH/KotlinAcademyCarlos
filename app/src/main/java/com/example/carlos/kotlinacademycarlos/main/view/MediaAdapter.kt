package com.example.carlos.kotlinacademycarlos.main.view

import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.carlos.kotlinacademycarlos.R
import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

class MediaAdapter(private val items: List<MediaItem>, private val itemClick: (MediaItem) -> Unit) : Adapter<MediaItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return MediaItemView(view, itemClick)
    }

    override fun onBindViewHolder(holder: MediaItemView, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
