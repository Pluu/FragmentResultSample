package com.pluu.fragmentresult.sample.manually

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentManuallyHomeBinding
import com.pluu.util.prettyString
import com.pluu.util.toast
import com.pluu.util.viewBinding

class ManuallyHomeFragment : Fragment(R.layout.fragment_manually_home) {

    private val binding by viewBinding(FragmentManuallyHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, ManuallyStep1Fragment::class.java, null)
                addToBackStack(null)
            }
        }

        setFragmentResultListener(ResultConstract.keyRoot) { _, result ->
            binding.tvResult.text = result.prettyString
        }

        setFragmentResultListener(ResultConstract.keyUnused) { _, result ->
            toast("Unused key ==> ${result.prettyString}")
        }
    }
}