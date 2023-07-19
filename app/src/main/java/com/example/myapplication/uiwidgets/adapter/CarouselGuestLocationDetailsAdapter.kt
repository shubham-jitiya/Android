package com.example.myapplication.uiwidgets.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.smarteist.autoimageslider.SliderViewAdapter

class CarouselGuestLocationDetailsAdapter(imageURL: ArrayList<String>) :
    SliderViewAdapter<CarouselGuestLocationDetailsAdapter.SliderViewHolder>() {

    var sliderImages = imageURL

    class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var headerImage: ImageView = itemView.findViewById(R.id.imageViewCarouselHeader)
    }

    override fun getCount(): Int {
        return sliderImages.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val layout = LayoutInflater.from(parent?.context)
            .inflate(R.layout.carousel_guest_location_details_header, null)
        return SliderViewHolder(layout)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        if (viewHolder != null) {
            Glide.with(viewHolder.itemView).load(sliderImages.get(position)).fitCenter()
                .into(viewHolder.headerImage)
        }
    }
}