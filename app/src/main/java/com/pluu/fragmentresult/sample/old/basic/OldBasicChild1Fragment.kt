package com.pluu.fragmentresult.sample.old.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldBasicChild1Binding
import com.pluu.util.viewbinding.viewBinding

class OldBasicChild1Fragment : Fragment(R.layout.fragment_old_basic_child1),
    OldBasicChild2Fragment.OnResultListener {

    private val binding by viewBinding(FragmentOldBasicChild1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restoreValue = arguments?.getString(keyRestore)
        if (restoreValue != null) {
            bindText(restoreValue)
        }

        binding.btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, OldBasicChild2Fragment().apply {
                    setListener(this@OldBasicChild1Fragment)
                })
                addToBackStack(null)
            }
        }
    }

    override fun onResult(value: String) {
        if (isVisible) {
            bindText(value)
        } else {
            arguments = (arguments ?: Bundle()).also {
                it.putString(keyRestore, value)
            }
        }
    }

    private fun bindText(value: String) {
        binding.tvResult.text = value
    }

    companion object {
        private const val keyRestore = "resultRestore"
    }
}