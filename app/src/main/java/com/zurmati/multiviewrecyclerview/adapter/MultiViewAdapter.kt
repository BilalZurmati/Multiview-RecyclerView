package com.zurmati.multiviewrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zurmati.multiviewrecyclerview.R
import com.zurmati.multiviewrecyclerview.models.ImageModel
import com.zurmati.multiviewrecyclerview.models.TextModel

class MultiViewAdapter(val context: Context, val items: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val txtDesc: TextView = itemView.findViewById(R.id.txt_desc)
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        val txtDesc: TextView = itemView.findViewById(R.id.txt_desc)
        val img: ImageView = itemView.findViewById(R.id.round_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == 0) {
            ImageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.layout_image_item, parent, false)
            )
        } else {
            TextViewHolder(
                LayoutInflater.from(context).inflate(R.layout.layout_text_item, parent, false)
            )
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ImageModel -> 0
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            val currentItem = items[position] as TextModel
            val imageHolder = holder as TextViewHolder


            imageHolder.txtTitle.text = currentItem.title
            imageHolder.txtDesc.text = currentItem.decription
            imageHolder.img.setImageResource(currentItem.image)

        } else {
            val currentItem = items[position] as ImageModel
            val textHolder = holder as ImageViewHolder

            textHolder.txtDesc.text = currentItem.description
            textHolder.img.setImageResource(currentItem.image)
        }
    }
}