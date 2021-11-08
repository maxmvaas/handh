package ru.maxmvaas.lesson_6_vasilev

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ThirdFragment : Fragment(R.layout.fragment_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val show = view.findViewById<MaterialButton>(R.id.show)
        var isShowed = false

        show.setOnClickListener {
            val fragment = PagerFragment.newInstance()

            if (!isShowed) {
                isShowed = true
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, fragment)
                    .addToBackStack(null)
                    .commit()
                show.text = getString(R.string.hide_banner)
            } else {
                isShowed = false
                for (fragment in childFragmentManager.fragments) {
                    childFragmentManager
                        .beginTransaction()
                        .remove(fragment)
                        .commit()
                }
            }
        }
    }
}