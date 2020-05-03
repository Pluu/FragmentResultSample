package com.pluu.fragmentresult.sample.manually

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentManuallyStep2Binding
import com.pluu.util.prettyString
import com.pluu.util.viewbinding.viewBinding

class ManuallyStep2Fragment : Fragment(R.layout.fragment_manually_step2) {

    private val binding by viewBinding(FragmentManuallyStep2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, ManuallyStepLastFragment::class.java, null)
                addToBackStack(null)
            }
        }

        binding.btnExit.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        setFragmentResultListener(ResultConstract.keyStep2) { _, result ->
            binding.tvResult.text = result.prettyString
        }
    }
}