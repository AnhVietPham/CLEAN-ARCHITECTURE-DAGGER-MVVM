package com.avp.mvvm_tesing.utils.extension

fun Double?.valueOrDefault(default: Double): Double {
    return this ?: default
}

fun Double?.valueOrZero(): Double {
    return this.valueOrDefault(default = 0.0)
}