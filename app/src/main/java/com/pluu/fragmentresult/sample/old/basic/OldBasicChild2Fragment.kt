package com.pluu.fragmentresult.sample.old.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldBasicChild2Binding
import com.pluu.util.viewbinding.viewBinding

class OldBasicChild2Fragment : Fragment(R.layout.fragment_old_basic_child2) {

    private var listener: OnResultListener? = null

    private val binding by viewBinding(FragmentOldBasicChild2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {
            listener?.onResult("Pending ==> Result")
            parentFragmentManager.popBackStack()
        }
    }

    fun setListener(listener: OnResultListener) {
        this.listener = listener
    }

    interface OnResultListener {
        fun onResult(value: String)
    }
}