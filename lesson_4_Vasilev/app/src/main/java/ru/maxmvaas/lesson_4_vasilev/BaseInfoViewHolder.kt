package ru.maxmvaas.lesson_4_vasilev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BaseInfoViewHolder(
    parent: ViewGroup,
    private val onItemClick: (String) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_base_info, parent, false)
) {
    private val textViewTitle by lazy { itemView.findViewById<TextView>(R.id.textViewTitle) }
    private val imageView by lazy { itemView.findViewById<ImageView>(R.id.imageView) }
    private val textViewDescription by lazy { itemView.findViewById<TextView>(R.id.textViewDescription) }

    fun bind(baseInfo: BaseInfo) {
        itemView.setOnClickListener {
            onItemClick(baseInfo.title)
        }

        imageView.setImageResource(baseInfo.image)
        textViewTitle.text = baseInfo.title
    }

    fun bind(detailInfo: DetailInfo) {
        itemView.setOnClickListener {
            onItemClick(detailInfo.title)
        }

        textViewDescription.visibility = View.VISIBLE
        textViewDescription.text = detailInfo.description
        textViewTitle.text = detailInfo.title
        imageView.setImageResource(detailInfo.image)
    }
}