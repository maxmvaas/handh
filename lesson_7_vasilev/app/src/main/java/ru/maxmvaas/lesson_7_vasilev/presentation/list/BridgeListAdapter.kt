package ru.maxmvaas.lesson_7_vasilev.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge

class BridgeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Bridge>()

    override fun getItemCount() = items.size

    fun setItems(items: List<Bridge>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    lateinit var onItemClick: (Bridge) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BridgeListViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BridgeListViewHolder).bind(items[position])
    }
}