package com.pluu.util

import android.content.Context
import android.util.TypedValue

fun Context.dp2Px(dp: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics
).toInt()