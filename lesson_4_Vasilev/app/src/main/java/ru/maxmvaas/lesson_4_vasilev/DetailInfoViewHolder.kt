package ru.maxmvaas.lesson_4_vasilev

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DetailInfoViewHolder(
    parent: ViewGroup,
    private val onItemClick: (String) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail_info, parent, false)
) {

    private val imageView by lazy { itemView.findViewById<ImageView>(R.id.imageView) }
    private val textViewTitle by lazy { itemView.findViewById<TextView>(R.id.textViewTitle) }
    private val textViewDescription by lazy { itemView.findViewById<TextView>(R.id.textViewDescription) }

    fun bind(detailItem: DetailInfo) {
        itemView.setOnClickListener {
            onItemClick(detailItem.title)
        }

        imageView.setImageResource(detailItem.image)
        textViewTitle.text = detailItem.title
        textViewDescription.text = detailItem.description

        if (detailItem.isRed) {
            textViewDescription.setTextColor(Color.RED)
        }
    }
}