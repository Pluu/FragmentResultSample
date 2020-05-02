package com.pluu.fragmentresult.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pluu.composer.add
import com.pluu.composer.button
import com.pluu.composer.setContentView
import com.pluu.fragmentresult.sample.manually.ManuallyActivity
import com.pluu.fragmentresult.sample.navigation.NavActivity
import com.pluu.fragmentresult.sample.stack.BetweenStackActivity
import com.pluu.util.dp2Px

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView {
            val defaultButtonStyle: Button.() -> Unit = {
                val buttonMinHeight = dp2Px(60f)
                minimumHeight = buttonMinHeight
                textSize = 18f
            }
            add(::LinearLayout) {
                orientation = LinearLayout.VERTICAL
                button(
                    text = "Manually Style",
                    measureResult = defaultButtonStyle
                ) {
                    startActivity(Intent(this@MainActivity, ManuallyActivity::class.java))
                }
                button(
                    text = "Navigation Style",
                    measureResult = defaultButtonStyle
                ) {
                    startActivity(Intent(this@MainActivity, NavActivity::class.java))
                }
                button(
                    text = "Crazy Stack ~ Between parent/child",
                    measureResult = defaultButtonStyle
                ) {
                    startActivity(Intent(this@MainActivity, BetweenStackActivity::class.java))
                }
            }
        }
    }
}