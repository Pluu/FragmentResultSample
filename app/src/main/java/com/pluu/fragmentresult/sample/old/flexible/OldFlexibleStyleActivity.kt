package com.pluu.fragmentresult.sample.old.flexible

import androidx.appcompat.app.AppCompatActivity
import com.pluu.fragmentresult.sample.R

class OldFlexibleStyleActivity : AppCompatActivity(R.layout.activity_old_flexible),
    OldFlexibleMasterFragment.OnResultListener {

    override fun onResult(value: String) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detail_fragment)
        if (fragment is OldFlexibleDetailFragment) {
            fragment.updateItem(value)
        }
    }
}