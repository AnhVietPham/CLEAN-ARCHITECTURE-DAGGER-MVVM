package com.avp.mvvm_tesing.domain.usecase.base

interface RawResultListener<in SuccessOutput> {
    fun success(successOutput: SuccessOutput)
    fun fail(throwable: Throwable)
}