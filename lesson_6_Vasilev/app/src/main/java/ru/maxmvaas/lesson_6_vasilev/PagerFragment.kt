package ru.maxmvaas.lesson_6_vasilev

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class PagerFragment : Fragment(R.layout.fragment_pager) {
    companion object {
        fun newInstance(): PagerFragment {
            return PagerFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dots = view.findViewById<DotsIndicator>(R.id.dotsIndicator)
        val pager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = PagerAdapter(this)
        val images = listOf(
            "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png",
            "https://cdn.mos.cms.futurecdn.net/KYEJp9vem3QQFGhi25SYx4-1200-80.jpg",
            "https://ychef.files.bbci.co.uk/976x549/p07ryyyj.jpg",
            "https://i.natgeofe.com/n/3861de2a-04e6-45fd-aec8-02e7809f9d4e/02-cat-training-NationalGeographic_1484324_2x1.jpg"
        )
        pager.adapter = adapter
        adapter.setItems(images)
        dots.setViewPager2(pager)
    }
}