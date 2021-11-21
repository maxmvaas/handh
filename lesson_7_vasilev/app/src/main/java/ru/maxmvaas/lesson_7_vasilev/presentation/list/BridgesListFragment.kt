package ru.maxmvaas.lesson_7_vasilev.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import ru.maxmvaas.lesson_7_vasilev.R
import ru.maxmvaas.lesson_7_vasilev.data.BridgeStatus
import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge
import ru.maxmvaas.lesson_7_vasilev.presentation.FragmentListener
import ru.maxmvaas.lesson_7_vasilev.presentation.bridge.BridgeFragment

class BridgesListFragment : Fragment(R.layout.fragment_bridges_list) {
    companion object {
        const val STATUS_LOADING = 0
        const val STATUS_DATA = 1
        const val STATUS_ERROR = 2
    }

    private val viewModel: BridgeListViewModel by viewModels()

    private fun loadBridges() {
        viewModel.loadBridges()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadBridges()
    }

    private val recyclerView
        get() = view?.findViewById<RecyclerView>(R.id.recyclerView)!!
    private val viewFlipper
        get() = view?.findViewById<ViewFlipper>(R.id.viewFlipper)!!
    private val textViewError
        get() = view?.findViewById<TextView>(R.id.textViewError)!!
    private val buttonRetry
        get() = view?.findViewById<MaterialButton>(R.id.buttonRetry)!!

    private var fragmentListener: FragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            fragmentListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bridgeListStatusLiveData.observe(viewLifecycleOwner, { status ->
            when (status) {
                is BridgeStatus.Loading -> {
                    setStatusLoading()
                }
                is BridgeStatus.Data -> {
                    if (status.data.isEmpty()) {
                        setStatusEmpty()
                    } else {
                        setStatusData(status.data)
                    }
                }
                is BridgeStatus.Error -> {
                    setStatusError(status.error)
                }
                else -> setStatusLoading()
            }

        })
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_info -> {
                    Toast.makeText(
                        context,
                        "Тут могла бы быть ваша реклама, но я пока не умею ее вставлять :(",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }
                R.id.menu_map -> {
                    Toast.makeText(context, "Я карта!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun setStatusLoading() {
        viewFlipper.displayedChild = STATUS_LOADING
    }

    private fun setStatusData(data: List<Bridge>) {
        viewFlipper.displayedChild = STATUS_DATA
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = BridgeListAdapter()
        adapter.setItems(data)
        adapter.onItemClick = {
            fragmentListener?.openFragment(BridgeFragment.newInstance(it))
        }
        recyclerView.adapter = adapter
    }

    private fun setStatusEmpty() {
        viewFlipper.displayedChild = STATUS_ERROR
        textViewError.text = "Кажется, в Питере больше нет мостов.."
        buttonRetry.setOnClickListener {
            loadBridges()
        }
    }

    private fun setStatusError(e: Exception) {
        viewFlipper.displayedChild = STATUS_ERROR
        textViewError.text = e.message
        buttonRetry.setOnClickListener {
            loadBridges()
        }
    }
}