package com.pluu.fragmentresult.sample.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentNavStep2Binding
import com.pluu.util.prettyString
import com.pluu.util.viewbinding.viewBinding

class NavStep2Fragment : Fragment(R.layout.fragment_nav_step2) {

    private val binding by viewBinding(FragmentNavStep2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_to_nav2)
        }

        binding.btnExit.setOnClickListener {
            findNavController().navigateUp()
        }

        setFragmentResultListener(ResultConstract.keyStep2) { _, result ->
            binding.tvResult.text = result.prettyString
        }
    }
}