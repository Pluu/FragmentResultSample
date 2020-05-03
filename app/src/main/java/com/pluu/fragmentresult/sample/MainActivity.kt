package com.pluu.fragmentresult.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.pluu.composer.add
import com.pluu.composer.button
import com.pluu.composer.setContentView
import com.pluu.fragmentresult.sample.flexible.FlexibleStyleActivity
import com.pluu.fragmentresult.sample.manually.ManuallyActivity
import com.pluu.fragmentresult.sample.navigation.NavActivity
import com.pluu.fragmentresult.sample.old.flexible.OldFlexibleStyleActivity
import com.pluu.fragmentresult.sample.old.nested.OldStyleActivity
import com.pluu.fragmentresult.sample.old.targetfragment.OldTargetFragmentActivity
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
            add(::ScrollView) {
                add(::LinearLayout) {
                    orientation = LinearLayout.VERTICAL
                    setPadding(dp2Px(10f))
                    bindOldPattern(defaultButtonStyle)
                    bindNewPattern(defaultButtonStyle)
                }
            }
        }
    }

    private fun LinearLayout.bindOldPattern(defaultButtonStyle: Button.() -> Unit) {
        button(
            text = "Old ~ Flexible Style",
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, OldFlexibleStyleActivity::class.java))
        }
        button(
            text = "Old ~ Nested Style",
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, OldStyleActivity::class.java))
        }
        button(
            text = "Old ~ TargetFragment",
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, OldTargetFragmentActivity::class.java))
        }
    }

    private fun LinearLayout.bindNewPattern(defaultButtonStyle: Button.() -> Unit) {
        button(
            text = "Flexible Style",
            bgColor = 0xFF81D4FA.toInt(),
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, FlexibleStyleActivity::class.java))
        }
        button(
            text = "Manually Style",
            bgColor = 0xFF81D4FA.toInt(),
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, ManuallyActivity::class.java))
        }
        button(
            text = "Navigation Style",
            bgColor = 0xFF81D4FA.toInt(),
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, NavActivity::class.java))
        }
        button(
            text = "Crazy Stack ~ Between parent/child",
            bgColor = 0xFF81D4FA.toInt(),
            measureResult = defaultButtonStyle
        ) {
            startActivity(Intent(this@MainActivity, BetweenStackActivity::class.java))
        }
    }
}