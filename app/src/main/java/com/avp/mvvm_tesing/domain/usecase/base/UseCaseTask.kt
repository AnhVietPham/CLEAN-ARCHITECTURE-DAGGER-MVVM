package com.avp.mvvm_tesing.domain.usecase.base

import io.reactivex.disposables.Disposable


class UseCaseTask(var disposable: Disposable) {
    fun cancel() {
        disposable.dispose()
    }
}