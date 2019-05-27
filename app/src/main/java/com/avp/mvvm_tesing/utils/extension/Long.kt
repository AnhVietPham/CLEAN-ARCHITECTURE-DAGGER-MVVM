package com.avp.mvvm_tesing.utils.extension

fun Long?.valueOrDefault(default: Long): Long {
    return this ?: default
}

fun Long?.valueOrZero(): Long {
    return this.valueOrDefault(default = 0)
}