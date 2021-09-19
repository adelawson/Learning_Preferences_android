package com.adelawson.learnpreferences

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (val context: Context, var imageList :ArrayList<GalleryImage> ): RecyclerView.Adapter<ImageAdapter.viewHolder>() {

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition:Int = -1
        private var currentImage: GalleryImage? = null

        private val cardImageView = itemView.findViewById<ImageView>(R.id.gallery_image)


        fun setData(image:GalleryImage,position: Int){
            cardImageView.setImageResource(image.imageID)


            this.currentPosition = position
            this.currentImage = image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.gallery_item,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: viewHolder, position: Int) {
        val image = imageList[position]
        viewHolder.setData(image,position)
    }

    override fun getItemCount(): Int = imageList.size

}