package com.pluu.fragmentresult.sample.flexible

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.ListFragment
import androidx.fragment.app.setFragmentResult

class FlexibleMasterFragment : ListFragment() {
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
        setFragmentResult(requestKey, bundleOf(resultKey to list[position]))
    }

    companion object {
        const val requestKey = "flexible"
        const val resultKey = "item"
    }
}