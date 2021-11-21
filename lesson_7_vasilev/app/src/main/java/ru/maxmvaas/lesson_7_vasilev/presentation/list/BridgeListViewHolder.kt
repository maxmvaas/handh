package ru.maxmvaas.lesson_7_vasilev.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.maxmvaas.lesson_7_vasilev.R
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge
import ru.maxmvaas.lesson_7_vasilev.databinding.ItemBridgeBinding

class BridgeListViewHolder(
    parent: ViewGroup,
    private val onItemClick: (Bridge) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_bridge, parent, false)
) {

    private val binding by viewBinding(ItemBridgeBinding::bind)

    private val imageViewStatus by lazy { binding.imageViewStatus }
    private val textViewName by lazy { binding.textViewName }
    private val textViewDivorces by lazy { binding.textViewDivorces }
    private val imageButtonNotification by lazy { binding.imageButtonNotification }

    fun bind(bridge: Bridge) {
        itemView.setOnClickListener {
            onItemClick(bridge)
        }
        textViewName.text = bridge.name
        textViewDivorces.text = buildString {
            for (divorce in bridge.divorces) {
                append("${divorce.start} - ${divorce.end}\t\t")
            }
        }
        imageViewStatus.setImageResource(bridge.getStatus())
        if (bridge.isNeedToRemind) {
            imageButtonNotification.setImageResource(R.drawable.ic_notification_on)
        }
        else {
            imageButtonNotification.setImageResource(R.drawable.ic_notification_off)
        }
        imageButtonNotification.setOnClickListener {
            if (!bridge.isNeedToRemind) {
                Toast.makeText(itemView.context, "Напоминание установлено!", Toast.LENGTH_SHORT).show()
                imageButtonNotification.setImageResource(R.drawable.ic_notification_on)
                bridge.isNeedToRemind = true
            } else {
                Toast.makeText(itemView.context, "Напоминание выключено!", Toast.LENGTH_SHORT).show()
                imageButtonNotification.setImageResource(R.drawable.ic_notification_off)
                bridge.isNeedToRemind = false
            }
        }
    }
}