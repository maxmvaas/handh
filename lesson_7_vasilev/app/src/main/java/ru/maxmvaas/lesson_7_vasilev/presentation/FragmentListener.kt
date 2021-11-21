package ru.maxmvaas.lesson_7_vasilev.presentation

import androidx.fragment.app.Fragment

interface FragmentListener {
    fun openFragment(fragment: Fragment)
    fun toPrevious()
}