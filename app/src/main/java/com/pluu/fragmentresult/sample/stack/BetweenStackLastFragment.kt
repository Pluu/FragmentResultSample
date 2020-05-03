package com.pluu.fragmentresult.sample.stack

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentBetweenStackLastBinding
import com.pluu.util.prettyString

class BetweenStackLastFragment : Fragment(R.layout.fragment_between_stack_last) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentBetweenStackLastBinding.bind(view)
        binding.btnConfirm.setOnClickListener {
            setFragmentResult(
                ResultConstract.keyRoot,
                bundleOf("key_string" to "==> root", "Int" to 0)
            )
            setFragmentResult(
                ResultConstract.keyStep1,
                bundleOf("key_string" to "==> stack1", "Int" to 1)
            )
            setFragmentResult(
                ResultConstract.keyStep2,
                bundleOf("key_string" to "==> stack2", "Int" to 2)
            )
            setFragmentResult(
                "current",
                bundleOf("key_string" to "==> current", "Int" to 3)
            )
        }

        setFragmentResultListener("current") { _, result ->
            binding.tvLabel.text = result.prettyString
        }
    }
}