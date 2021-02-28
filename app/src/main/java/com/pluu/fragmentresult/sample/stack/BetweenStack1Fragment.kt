package com.pluu.fragmentresult.sample.stack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentBetweenStack1Binding
import com.pluu.util.prettyString
import com.pluu.util.setChildFragmentResultListener

class BetweenStack1Fragment : Fragment(R.layout.fragment_between_stack1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBetweenStack1Binding.bind(view)

        setChildFragmentResultListener(ResultConstract.keyStep1) { _, result ->
            binding.tvLabel.text = result.prettyString
        }
        setChildFragmentResultListener(ResultConstract.keyRoot) { requestKey, result ->
            setFragmentResult(requestKey, result)
        }
    }
}