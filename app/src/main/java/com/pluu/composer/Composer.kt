package com.pluu.composer

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewManager
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment

inline fun Activity.setContentView(ui: ViewManager.() -> Unit) =
    ActivityViewManager(this).apply(ui)

class ActivityViewManager(
    val activity: Activity
) : ViewManager {
    override fun addView(view: View?, params: ViewGroup.LayoutParams?) {
        activity.setContentView(view)
    }

    override fun updateViewLayout(view: View?, params: ViewGroup.LayoutParams?) {}

    override fun removeView(view: View?) {}
}

inline fun Fragment.setContentView(ui: ViewManager.() -> Unit) =
    FragmentViewManager(view!!).apply(ui)

class FragmentViewManager(
    val rootView: View
) : ViewManager {
    override fun addView(view: View?, params: ViewGroup.LayoutParams?) {
        (rootView as ViewGroup).addView(view)
    }

    override fun updateViewLayout(view: View?, params: ViewGroup.LayoutParams?) {}

    override fun removeView(view: View?) {}
}

val ViewManager.context
    get() = when (this) {
        is View -> context
        is ActivityViewManager -> activity
        is FragmentViewManager -> rootView.context
        else -> TODO()
    }

fun <VM : ViewManager, V : View> VM.add(
    construct: (Context) -> V,
    width: Int = MATCH_PARENT,
    height: Int = WRAP_CONTENT,
    init: V.() -> Unit
) {
    construct(context).apply(init).also {
        addView(it, ViewGroup.LayoutParams(width, height))
    }
}

fun ViewManager.text(text: String) {
    add(::TextView) {
        this.text = text
        transformationMethod = null
    }
}

fun ViewManager.button(
    text: String,
    color: Int = Color.LTGRAY,
    measureResult: Button.() -> Unit = {},
    listener: (View) -> Unit
) {
    add(::Button) {
        this.text = text
        transformationMethod = null
        measureResult(this)

        val bgDrawable = DrawableCompat.wrap(background)
        DrawableCompat.setTint(bgDrawable, color)
//        backgroundTintMode = ColorStateList.valueOf(color)
        setOnClickListener(listener)
    }
}