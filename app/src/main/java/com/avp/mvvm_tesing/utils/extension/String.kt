package com.avp.mvvm_tesing.utils.extension

fun String?.valueOrDefault(default: String): String {
    return this ?: default
}

fun String?.valueOrEmpty(): String {
    return this.valueOrDefault(default = "")
}