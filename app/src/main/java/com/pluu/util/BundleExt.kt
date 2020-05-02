package com.pluu.util

import android.os.Bundle

inline val Bundle.prettyString: String
    get() = keySet()
        .map { it to get(it) }
        .joinToString()