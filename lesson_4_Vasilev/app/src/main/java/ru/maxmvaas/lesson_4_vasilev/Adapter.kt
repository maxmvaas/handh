package ru.maxmvaas.lesson_4_vasilev

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val DETAIL_INFO = 0
        const val BASE_INFO = 1
        const val DETAIL_INFO_HORIZONTAL = 2
    }

    private val items = mutableListOf<AdapterElement>()

    lateinit var onItemClick: (String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BASE_INFO -> BaseInfoViewHolder(parent, onItemClick)
            DETAIL_INFO -> DetailInfoViewHolder(parent, onItemClick)
            DETAIL_INFO_HORIZONTAL -> BaseInfoViewHolder(parent, onItemClick)
            else -> throw Exception("Unsupported View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BASE_INFO -> (holder as BaseInfoViewHolder).bind(items[position] as BaseInfo)
            DETAIL_INFO -> (holder as DetailInfoViewHolder).bind(items[position] as DetailInfo)
            DETAIL_INFO_HORIZONTAL -> (holder as BaseInfoViewHolder).bind(items[position] as DetailInfo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<AdapterElement>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is BaseInfo) {
            BASE_INFO
        } else {
            if (position == 6) {
                DETAIL_INFO_HORIZONTAL
            } else {
                DETAIL_INFO
            }
        }
    }
}