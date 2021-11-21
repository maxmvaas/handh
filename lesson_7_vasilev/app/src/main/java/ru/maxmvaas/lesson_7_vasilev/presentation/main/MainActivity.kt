package ru.maxmvaas.lesson_7_vasilev.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.maxmvaas.lesson_7_vasilev.R
import ru.maxmvaas.lesson_7_vasilev.presentation.FragmentListener
import ru.maxmvaas.lesson_7_vasilev.presentation.list.BridgesListFragment

class MainActivity : AppCompatActivity(), FragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, BridgesListFragment())
            .commit()
    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun toPrevious() {
        supportFragmentManager
            .popBackStack()
    }
}