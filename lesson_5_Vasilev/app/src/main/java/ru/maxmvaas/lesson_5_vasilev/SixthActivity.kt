package ru.maxmvaas.lesson_5_vasilev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class SixthActivity : AppCompatActivity() {

    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, SixthActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val services = ArrayList<Service>()
        services.add(
            Service(
                "Царь пышка",
                "Скидка 10% на выпечку по коду",
                "Лермонтовский пр, 52, МО №1",
                false,
                R.drawable.tsar
            )
        )
        services.add(
            Service(
                "Химчистка «МАЙ?»",
                "Скидка 5% на чистку пальто",
                "Лермонтовский пр, 48",
                true,
                R.drawable.may
            )
        )
        services.add(
            Service(
                "Шаверма У Ашота",
                "При покупке шавермы, фалафель бесплатно",
                "Лермонтовский пр, 52, МО №1",
                false,
                R.drawable.ashot
            )
        )
        val adapter = ServiceAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setItems(services)
        adapter.onItemClick = { item ->
            Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        }
        registerForContextMenu(recyclerView)
        recyclerView.addItemDecoration(Decorator(35))
        findViewById<MaterialButton>(R.id.addService).setOnClickListener {
            Toast.makeText(this, "Предложить услугу", Toast.LENGTH_SHORT).show()
        }
        findViewById<MaterialButton>(R.id.showAll).setOnClickListener {
            Toast.makeText(this, "Показать все", Toast.LENGTH_SHORT).show()
        }
    }
}