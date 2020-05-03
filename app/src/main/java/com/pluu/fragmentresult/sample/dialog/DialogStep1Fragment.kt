package com.pluu.fragmentresult.sample.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentDialogStep1Binding
import com.pluu.util.prettyString
import com.pluu.util.viewbinding.viewBinding

class DialogStep1Fragment : Fragment(R.layout.fragment_dialog_step1) {

    private val binding by viewBinding(FragmentDialogStep1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            DialogStepLastFragment()
                .show(parentFragmentManager, DialogStepLastFragment::class.java.simpleName)
        }

        setFragmentResultListener(DialogStepLastFragment.requestKey) { _, result ->
            binding.tvResult.text = result.prettyString
        }
    }
}