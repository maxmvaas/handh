package ru.maxmvaas.lesson_6_vasilev

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ElectricityViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_electricity, parent, false)
) {

    private val imageView by lazy { itemView.findViewById<ImageView>(R.id.image) }
    private val infoButton by lazy { itemView.findViewById<ImageButton>(R.id.info) }
    private val contextMenu by lazy { itemView.findViewById<ImageButton>(R.id.contextMenu) }
    private val sendButton by lazy { itemView.findViewById<ImageButton>(R.id.send) }

    fun bind(electricity: Electricity) {
        imageView.setImageResource(R.drawable.ic_electro_copy)

        infoButton.setOnClickListener {
            Toast.makeText(itemView.context, "Инфо", Toast.LENGTH_SHORT).show()
        }
        contextMenu.setOnClickListener {
            Toast.makeText(itemView.context, "Тут могло бы быть что-то еще.", Toast.LENGTH_SHORT).show()
        }
        sendButton.setOnClickListener {
            Toast.makeText(itemView.context, "Отправить", Toast.LENGTH_SHORT).show()
        }
    }
}