package com.pluu.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.setFragmentResultListener

fun Fragment.setChildFragmentResultListener(
    requestKey: String,
    listener: ((resultKey: String, bundle: Bundle) -> Unit)?
) {
    childFragmentManager.setFragmentResultListener(requestKey, this, listener)
}

fun FragmentActivity.setFragmentResultListener(
    requestKey: String,
    listener: ((resultKey: String, bundle: Bundle) -> Unit)?
) {
    supportFragmentManager.setFragmentResultListener(requestKey, this, listener)
}