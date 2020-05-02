package com.pluu.fragmentresult.sample.stack

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentBetweenLastBinding

class BetweenLastFragment : Fragment(R.layout.fragment_between_last) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentBetweenLastBinding.bind(view)
        binding.btnConfirm.setOnClickListener {
            setFragmentResult(
                ResultConstract.keyRoot,
                bundleOf("key_string" to "==> root", "Int" to 1)
            )
            setFragmentResult(
                ResultConstract.keyStack1,
                bundleOf("key_string" to "==> stack1", "Int" to 2)
            )
            setFragmentResult(
                ResultConstract.keyStack2,
                bundleOf("key_string" to "==> stack2", "Int" to 3)
            )
        }
    }
}