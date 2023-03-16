package com.zurmati.multiviewrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zurmati.multiviewrecyclerview.R

class MultiViewAdapter(val context: Context, val items: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt: TextView = itemView.findViewById(R.id.txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == 1) {
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
            is String -> 0
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            val currentItem = items[position] as Int
            val imageHolder = holder as ImageViewHolder


            imageHolder.img.setImageResource(currentItem)

        } else {
            val currentItem = items[position] as String
            val textHolder = holder as TextViewHolder

            textHolder.txt.text = currentItem
        }
    }
}