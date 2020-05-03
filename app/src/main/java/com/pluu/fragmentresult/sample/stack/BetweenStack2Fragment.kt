package com.pluu.fragmentresult.sample.stack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentBetweenStack2Binding
import com.pluu.util.prettyString
import com.pluu.util.setChildFragmentResultListener

class BetweenStack2Fragment : Fragment(R.layout.fragment_between_stack2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBetweenStack2Binding.bind(view)

        setChildFragmentResultListener(ResultConstract.keyStep2) { _, result ->
            binding.tvLabel.text = result.prettyString
        }
        setChildFragmentResultListener(ResultConstract.keyRoot) { resultKey, result ->
            setFragmentResult(resultKey, result)
        }
        setChildFragmentResultListener(ResultConstract.keyStep1) { resultKey, result ->
            setFragmentResult(resultKey, result)
        }
    }
}