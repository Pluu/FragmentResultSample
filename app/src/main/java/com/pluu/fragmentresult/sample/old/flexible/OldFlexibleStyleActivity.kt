package com.pluu.fragmentresult.sample.old.flexible

import androidx.appcompat.app.AppCompatActivity
import com.pluu.fragmentresult.sample.R
import com.pluu.fragmentresult.sample.databinding.ActivityOldFlexibleBinding
import com.pluu.util.viewbinding.viewBinding

class OldFlexibleStyleActivity : AppCompatActivity(R.layout.activity_old_flexible),
    OldFlexibleMasterFragment.OnResultListener {

    private val binding by viewBinding(ActivityOldFlexibleBinding::bind)

    override fun onResult(value: String) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detail_fragment)
        if (fragment is OldFlexibleDetailFragment) {
            fragment.updateItem(value)
        }
    }
}