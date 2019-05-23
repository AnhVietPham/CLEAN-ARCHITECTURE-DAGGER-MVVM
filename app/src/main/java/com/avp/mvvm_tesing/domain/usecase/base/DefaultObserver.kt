package com.avp.mvvm_tesing.domain.usecase.base

import io.reactivex.observers.DisposableSingleObserver

class DefaultObserver<SuccessOutput, FailOutput>(private val failOutputFactory: (Throwable) -> FailOutput) :
    DisposableSingleObserver<SuccessOutput>() {
    private val resultListeners = mutableListOf<ResultListener<SuccessOutput, FailOutput>>()
    private val rawResultListeners = mutableListOf<RawResultListener<SuccessOutput>>()

    fun addResultListener(resultListener: ResultListener<SuccessOutput, FailOutput>) {
        resultListeners.add(resultListener)
    }

    fun addRawResultListener(rawResultListener: RawResultListener<SuccessOutput>) {
        rawResultListeners.add(rawResultListener)
    }

    private fun fireSuccess(data: SuccessOutput) {
        resultListeners.forEach { resultListener -> resultListener.success(data) }
        rawResultListeners.forEach { resultListener -> resultListener.success(data) }
    }

    private fun fireFail(throwable: Throwable) {
        val failOutput = failOutputFactory.invoke(throwable)
        resultListeners.forEach { resultListener ->
            resultListener.fail(failOutput)
        }
        rawResultListeners.forEach { resultListener ->
            resultListener.fail(throwable)
        }
    }

    override fun onSuccess(data: SuccessOutput) {
        fireSuccess(data)
    }

    override fun onError(error: Throwable) {
        fireFail(error)
    }

}