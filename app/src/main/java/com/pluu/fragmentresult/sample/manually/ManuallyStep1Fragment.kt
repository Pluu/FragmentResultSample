package com.pluu.fragmentresult.sample.manually

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentManuallyStep1Binding
import com.pluu.util.prettyString
import com.pluu.util.toast
import com.pluu.util.viewbinding.viewBinding

class ManuallyStep1Fragment : Fragment(R.layout.fragment_manually_step1) {

    private val binding by viewBinding(FragmentManuallyStep1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, ManuallyStep2Fragment::class.java, null)
                addToBackStack(null)
            }
        }

        setFragmentResultListener(ResultConstract.keyStep1) { _, result ->
            binding.tvResult.text = result.prettyString
        }

        setFragmentResultListener(ResultConstract.keyUnused) { _, result ->
            toast("Unused key ==> ${result.prettyString}")
        }
    }
}