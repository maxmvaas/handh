package ru.maxmvaas.lesson_7_vasilev.presentation.bridge

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.maxmvaas.lesson_7_vasilev.R
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge.Companion.STATUS_LATE
import ru.maxmvaas.lesson_7_vasilev.databinding.FragmentBridgeBinding
import ru.maxmvaas.lesson_7_vasilev.presentation.FragmentListener

class BridgeFragment : Fragment(R.layout.fragment_bridge) {
    companion object {
        fun newInstance(bridge: Bridge): BridgeFragment {
            return BridgeFragment().apply {
                arguments = bundleOf(
                    EXTRA_BRIDGE to bridge
                )
            }
        }

        const val EXTRA_BRIDGE = "extra bridge"
    }

    private var fragmentListener: FragmentListener? = null

    private val bridge by lazy {
        arguments?.getParcelable<Bridge>(EXTRA_BRIDGE)!!
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            fragmentListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val imageViewToolbarBackground = view.findViewById<ImageView>(R.id.imageViewToolbarBackground)
        toolbar.setNavigationOnClickListener {
            fragmentListener!!.toPrevious()
        }

        view.findViewById<ImageView>(R.id.imageViewStatus).setImageResource(bridge.getStatus())
        view.findViewById<TextView>(R.id.textViewName).text = bridge.name
        view.findViewById<TextView>(R.id.textViewDescription).text = bridge.description
        view.findViewById<TextView>(R.id.textViewDivorces).text = buildString {
            for (divorce in bridge.divorces) {
                append("${divorce.start} - ${divorce.end}\t\t")
            }
        }

        Glide.with(this)
            .load(if (bridge.getStatus() == STATUS_LATE) bridge.photoCloseUrl else bridge.photoOpenUrl)
            .centerCrop()
            .into(imageViewToolbarBackground)

        view.findViewById<FrameLayout>(R.id.frameLayoutReminder).setOnClickListener {
            it.setBackgroundColor( resources.getColor(R.color.notification_on))
        }
    }
}