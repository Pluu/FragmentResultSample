package com.pluu.fragmentresult.sample

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pluu.composer.add
import com.pluu.composer.button
import com.pluu.composer.setContentView
import com.pluu.fragmentresult.sample.stack.BetweenStackActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView {
            add(::LinearLayout) {
                orientation = LinearLayout.VERTICAL
                button("Crazy Stack ~ Between parent/child") {
                    startActivity(Intent(this@MainActivity, BetweenStackActivity::class.java))
                }
            }
        }
    }
}