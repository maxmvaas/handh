package ru.maxmvaas.lesson_5_vasilev

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter : RecyclerView.Adapter<ServiceViewHolder>() {

    private val items = mutableListOf<Service>()

    lateinit var onItemClick: (Service) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<Service>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}