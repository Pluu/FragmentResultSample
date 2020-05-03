package com.pluu.fragmentresult.sample.manually

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.pluu.fragmentresult.sample.R

class ManuallyActivity : AppCompatActivity(R.layout.activity_manually) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.elevation = 0f

        supportFragmentManager.commit {
            add(R.id.container, ManuallyStep1Fragment::class.java, null)
        }
    }
}