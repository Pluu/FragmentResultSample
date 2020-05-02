package com.pluu.fragmentresult.sample.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentNavHomeBinding
import com.pluu.util.prettyString
import com.pluu.util.toast
import com.pluu.util.viewBinding

class NavHomeFragment : Fragment(R.layout.fragment_nav_home) {

    private val binding by viewBinding(FragmentNavHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_to_nav1)
        }

        setFragmentResultListener(ResultConstract.keyRoot) { _, result ->
            binding.tvResult.text = result.prettyString
        }

        setFragmentResultListener(ResultConstract.keyUnused) { _, result ->
            toast("Unused key ==> ${result.prettyString}")
        }
    }
}