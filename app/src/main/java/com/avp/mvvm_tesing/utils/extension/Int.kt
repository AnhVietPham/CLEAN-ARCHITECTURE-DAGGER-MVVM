package com.avp.mvvm_tesing.utils.extension

fun Int?.valueOrDefault(default: Int): Int {
    return this ?: default
}

fun Int?.valueOrZero(): Int {
    return this.valueOrDefault(default = 0)
}