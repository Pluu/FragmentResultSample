package com.pluu.fragmentresult.sample.navigation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.FragmentNavStepLastBinding
import com.pluu.util.toast
import com.pluu.util.viewbinding.viewBinding

class NavStepLastFragment : Fragment(R.layout.fragment_nav_step_last) {

    private val binding by viewBinding(FragmentNavStepLastBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirm.setOnClickListener {
            setFragmentResult(
                ResultConstract.keyStep1,
                bundleOf("key_string" to "==> step1", "Int" to 1)
            )
            setFragmentResult(
                ResultConstract.keyStep2,
                bundleOf("key_string" to "==> step2", "Int" to 2)
            )
            setFragmentResult(
                ResultConstract.keyUnused,
                bundleOf("key_string" to "==> keyUnused", "Int" to 3)
            )

            toast("Done, result set")
        }

        binding.btnExit.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}