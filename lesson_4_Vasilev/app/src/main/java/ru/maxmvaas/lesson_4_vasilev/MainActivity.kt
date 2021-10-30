package ru.maxmvaas.lesson_4_vasilev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickListener()

        val items = ArrayList<AdapterElement>()
        items.add(DetailInfo("Квитанции", "- 40 080,55 ₽", R.drawable.ic_bill, true))
        items.add(DetailInfo("Счетчики", "Подайте показания", R.drawable.ic_counters, true))
        items.add(DetailInfo("Рассрочка", "Сл. платеж 25.02.2018", R.drawable.ic_installment, false))
        items.add(DetailInfo("Страхование", "Полис до 12.01.2019", R.drawable.ic_insurance, false))
        items.add(DetailInfo("Интернет и ТВ", "Баланс 350 ₽", R.drawable.ic_internet, false))
        items.add(DetailInfo("Домофон", "Подключен", R.drawable.ic_guard, false))
        items.add(DetailInfo("Охрана", "Нет", R.drawable.ic_bill, false))
        items.add(BaseInfo("Контакты УК и служб", R.drawable.ic_contacts))
        items.add(BaseInfo("Мои заявки", R.drawable.ic_requests))
        items.add(BaseInfo("Памятка жителя А101", R.drawable.ic_memo))
        val adapter = Adapter()
        adapter.setItems(items)
        recyclerView.adapter = adapter
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) = if (position < 6) 1 else 2
        }
        recyclerView.addItemDecoration(CustomDecorator(8, 8))
        recyclerView.layoutManager = layoutManager
        adapter.onItemClick = { itemTitle ->
            Snackbar.make(recyclerView, itemTitle, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun clickListener() {
        toolbar.setNavigationOnClickListener {}
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.info -> {
                    AlertDialog.Builder(this)
                        .setTitle("Оповещение")
                        .setMessage(
                            "Поздравляем!! Вы наш 10000 посетитель.\nПоэтому вы выиграли приз - Apple MacBook Pro 13.3, 2020!\n" +
                                "Чтобы забрать его хлопните в ладоши пять раз, подпрыгните 2 раза и загляните под подушку!!"
                        )
                        .setPositiveButton("Ладно...") { dialog, _ ->
                            dialog.dismiss()
                        }.create().show()
                }
                R.id.home -> {
                    Toast.makeText(this, "Домой.", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

}