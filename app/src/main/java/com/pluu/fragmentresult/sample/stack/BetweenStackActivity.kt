package com.pluu.fragmentresult.sample.stack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.fragmentresult.sample.ResultConstract
import com.pluu.fragmentresult.sample.databinding.ActivityBetweenStackBinding
import com.pluu.util.prettyString
import com.pluu.util.setFragmentResultListener

class BetweenStackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBetweenStackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragmentResultListener(ResultConstract.keyRoot) { _, result ->
            binding.tvLabel.text = result.prettyString
        }
    }
}