package ru.maxmvaas.lesson_6_vasilev

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ImagesFragment : Fragment(R.layout.fragment_images) {
    companion object {
        const val EXTRA_POSITION = "pos"
        const val EXTRA_URL = "url"

        fun newInstance(url: String, position: Int): ImagesFragment {
            return ImagesFragment().apply {
                arguments = bundleOf(
                    EXTRA_POSITION to position + 1,
                    EXTRA_URL to url
                )
            }
        }
    }

    private val url by lazy { arguments?.getString(EXTRA_URL) }
    private val position by lazy { arguments?.getInt(EXTRA_POSITION) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerImage = view.findViewById<ImageView>(R.id.pagerImage)
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(pagerImage)
        val textPager = view.findViewById<TextView>(R.id.textPager)
        textPager.text = "Картинка $position"
        pagerImage.setOnClickListener {
            Toast.makeText(context, textPager.text, Toast.LENGTH_SHORT).show()
        }

    }
}