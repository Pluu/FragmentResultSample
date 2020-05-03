package com.pluu.fragmentresult.sample.flexible

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentFlexibleDetailBinding
import com.pluu.util.viewbinding.viewBinding

class FlexibleDetailFragment : Fragment(R.layout.fragment_flexible_detail) {

    private val binding by viewBinding(FragmentFlexibleDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(FlexibleMasterFragment.requestKey) { _, bundle ->
            binding.tvLabel.text = bundle.getString(FlexibleMasterFragment.resultKey)
        }
    }
}