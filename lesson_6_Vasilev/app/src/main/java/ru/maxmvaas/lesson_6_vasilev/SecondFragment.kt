package ru.maxmvaas.lesson_6_vasilev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import androidx.recyclerview.widget.LinearLayoutManager

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        val items = ArrayList<Services>()
        items.add(Water(false))
        items.add(Water(true))
        items.add(
            Electricity(
                this.getString(R.string.electro_description),
                R.drawable.ic_electro_copy
            )
        )
        val adapter = Adapter()
        adapter.setItems(items)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        toolbar.setOnMenuItemClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            true
        }
    }
}