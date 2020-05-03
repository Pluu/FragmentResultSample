package com.pluu.fragmentresult.sample.old.nested

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.FragmentOldNestedLastBinding
import com.pluu.util.viewbinding.viewBinding

class OldNestedStepLastFragment : Fragment(R.layout.fragment_old_nested_last) {

    private val binding by viewBinding(FragmentOldNestedLastBinding::bind)

    private var activityListener: ResultActivityOldListener? = null
    private var fragmentListener: ResultOldListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {
            activityListener?.onResultValue("Child Fragment ==> Activity")
            fragmentListener?.onResultValue("Child Fragment ==> Fragment")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ResultActivityOldListener) {
            activityListener = context
        }

        val parentFragment = parentFragment
        if (parentFragment is ResultOldListener) {
            fragmentListener = parentFragment
        }
    }
}