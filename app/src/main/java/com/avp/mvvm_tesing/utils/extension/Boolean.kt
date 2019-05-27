package com.avp.mvvm_tesing.utils.extension

fun Boolean?.valueOrDefault(default: Boolean): Boolean {
    return this ?: default
}

fun Boolean?.valueOrFalse(): Boolean {
    return this.valueOrDefault(default = false)
}