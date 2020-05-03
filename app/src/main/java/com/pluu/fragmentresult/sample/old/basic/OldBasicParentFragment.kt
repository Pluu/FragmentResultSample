package com.pluu.fragmentresult.sample.old.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.pluu.fragmentresult.sample.R

class OldBasicParentFragment : Fragment(R.layout.fragment_old_basic_parent) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.commit {
            add(R.id.container, OldBasicChild1Fragment::class.java, null)
        }
    }
}