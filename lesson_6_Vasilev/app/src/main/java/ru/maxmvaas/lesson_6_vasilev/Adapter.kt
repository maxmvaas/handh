package ru.maxmvaas.lesson_6_vasilev

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val WATER = 0
        const val ELECTRICITY = 1
    }

    private val items = mutableListOf<Services>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            WATER -> WaterViewHolder(parent)
            ELECTRICITY -> ElectricityViewHolder(parent)
            else -> throw Exception("Unsupported View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            WATER -> (holder as WaterViewHolder).bind(items[position] as Water)
            ELECTRICITY -> (holder as ElectricityViewHolder).bind(items[position] as Electricity)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Services>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is Water) {
            WATER
        } else {
            ELECTRICITY
        }
    }
}