package com.pluu.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Fragment.setChildFragmentResultListener(
    requestKey: String,
    listener: (requestKey: String, bundle: Bundle) -> Unit
) {
    childFragmentManager.setFragmentResultListener(requestKey, this, listener)
}

fun FragmentActivity.setFragmentResultListener(
    requestKey: String,
    listener: (requestKey: String, bundle: Bundle) -> Unit
) {
    supportFragmentManager.setFragmentResultListener(requestKey, this, listener)
}