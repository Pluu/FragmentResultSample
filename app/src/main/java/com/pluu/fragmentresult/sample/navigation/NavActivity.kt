package com.pluu.fragmentresult.sample.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.fragmentresult.sample.R

class NavActivity : AppCompatActivity(R.layout.activity_nav) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.elevation = 0f
    }
}