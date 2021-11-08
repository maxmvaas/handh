package ru.maxmvaas.lesson_6_vasilev

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class WaterViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_water, parent, false)
) {
    private val textViewTitle by lazy { itemView.findViewById<TextView>(R.id.title) }
    private val imageView by lazy { itemView.findViewById<ImageView>(R.id.waterColor) }
    private val infoButton by lazy { itemView.findViewById<ImageButton>(R.id.info) }
    private val contextMenu by lazy { itemView.findViewById<ImageButton>(R.id.contextMenu) }
    private val sendButton by lazy { itemView.findViewById<ImageButton>(R.id.send) }

    fun bind(water: Water) {
        if (water.temp) {
            textViewTitle.text = "Горячая вода"
            imageView.setImageResource(R.drawable.ic_water_hot)
        } else {
            textViewTitle.text = "Холодная вода"
            imageView.setImageResource(R.drawable.ic_water_cold)
        }
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