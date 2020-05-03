package com.pluu.fragmentresult.sample.old.nested

import androidx.appcompat.app.AppCompatActivity
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.ActivityOldNestedStyleBinding
import com.pluu.util.viewbinding.viewBinding

class OldStyleActivity : AppCompatActivity(R.layout.activity_old_nested_style), ResultActivityOldListener {

    private val binding by viewBinding(ActivityOldNestedStyleBinding::bind)

    override fun onResultValue(value: String) {
        binding.tvLabel.text = value
    }
}

interface ResultActivityOldListener {
    fun onResultValue(value: String)
}
