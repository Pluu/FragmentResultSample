package com.pluu.fragmentresult.sample.old.targetfragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldTargetStep1Binding
import com.pluu.util.prettyString
import com.pluu.util.viewbinding.viewBinding

class OldTargetStep1Fragment : Fragment(R.layout.fragment_old_target_step1) {

    private val binding by viewBinding(FragmentOldTargetStep1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            val fragment = OldTargetStepDialogFragment().apply {
                setTargetFragment(this@OldTargetStep1Fragment, sampleTargetRequestCode)
            }
            fragment.show(parentFragmentManager, OldTargetStepDialogFragment::class.java.simpleName)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == sampleTargetRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                binding.tvResult.text = data?.extras?.prettyString
            }
        }
    }

    companion object {
        const val sampleTargetRequestCode = 100
    }
}