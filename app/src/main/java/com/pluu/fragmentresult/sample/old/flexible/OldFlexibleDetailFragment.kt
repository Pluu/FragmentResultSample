package com.pluu.fragmentresult.sample.old.flexible

import androidx.fragment.app.Fragment
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldFlexibleDetailBinding
import com.pluu.util.viewbinding.viewBinding

class OldFlexibleDetailFragment : Fragment(R.layout.fragment_old_flexible_detail) {

    private val binding by viewBinding(FragmentOldFlexibleDetailBinding::bind)

    fun updateItem(value: String) {
        binding.tvLabel.text = value
    }
}