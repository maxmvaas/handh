package ru.maxmvaas.lesson_6_vasilev

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val items = mutableListOf<String>()

    override fun createFragment(position: Int): Fragment {
        return ImagesFragment.newInstance(items[position], position)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<String>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }


}