package com.pluu.fragmentresult.sample.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentNav1Binding
import com.pluu.util.prettyString
import com.pluu.util.viewBinding

class Nav1Fragment : Fragment(R.layout.fragment_nav1) {

    private val binding by viewBinding(FragmentNav1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_to_nav2)
        }

        binding.btnExit.setOnClickListener {
            findNavController().navigateUp()
        }

        setFragmentResultListener(ResultConstract.keyStack1) { _, result ->
            binding.tvResult.text = result.prettyString
        }
    }
}