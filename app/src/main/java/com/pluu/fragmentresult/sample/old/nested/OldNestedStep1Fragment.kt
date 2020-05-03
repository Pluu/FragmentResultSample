package com.pluu.fragmentresult.sample.old.nested

import androidx.fragment.app.Fragment
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldNestedStep1Binding
import com.pluu.util.viewbinding.viewBinding

class OldNestedStep1Fragment : Fragment(R.layout.fragment_old_nested_step1), ResultOldListener {

    private val binding by viewBinding(FragmentOldNestedStep1Binding::bind)

    override fun onResultValue(value: String) {
        binding.tvResult.text = value
    }
}

interface ResultOldListener {
    fun onResultValue(value: String)
}
