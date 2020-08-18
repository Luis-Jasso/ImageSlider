package com.viajero.slider

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SliderAdapter(var context: Context, private val list: List<Int>) :
    RecyclerView.Adapter<SliderAdapter.ViewHolderSlider>() {

    inner class ViewHolderSlider(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_slider_images,
            parent,
            false
        )
        return ViewHolderSlider(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderSlider, position: Int) {
        val image = holder.itemView.findViewById<ImageView>(R.id.itemImageView)
        Glide.with(context)
            .load(list[position])
            .into(image)
    }
}