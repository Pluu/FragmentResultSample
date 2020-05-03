package com.pluu.fragmentresult.sample.old.flexible

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class OldFlexibleMasterFragment : ListFragment() {
    private var listener: OnResultListener? = null

    private val list = (0..20).map {
        "Item $it"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Color.WHITE)
        listAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            list
        )
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        listener?.onResult(list[position])
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnResultListener) {
            listener = context
        }
    }

    interface OnResultListener {
        fun onResult(value: String)
    }
}