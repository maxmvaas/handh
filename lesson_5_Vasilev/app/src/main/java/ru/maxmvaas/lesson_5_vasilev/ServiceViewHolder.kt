package ru.maxmvaas.lesson_5_vasilev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceViewHolder(
    parent: ViewGroup,
    private val onItemClick: (Service) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
) {

    private val imageView by lazy { itemView.findViewById<ImageView>(R.id.image) }
    private val textViewTitle by lazy { itemView.findViewById<TextView>(R.id.title) }
    private val textViewDescription by lazy { itemView.findViewById<TextView>(R.id.description) }
    private val textViewAdress by lazy { itemView.findViewById<TextView>(R.id.adress) }
    private val imageViewFavorite by lazy { itemView.findViewById<ImageView>(R.id.favorite) }

    fun bind(service: Service) {
        itemView.setOnClickListener {
            onItemClick(service)
        }
        imageView.setImageResource(service.image)
        textViewTitle.text = service.name
        textViewDescription.text = service.description
        textViewAdress.text = service.adress
        if (service.isFavorite) {
            imageViewFavorite.visibility = View.VISIBLE
        }
    }
}