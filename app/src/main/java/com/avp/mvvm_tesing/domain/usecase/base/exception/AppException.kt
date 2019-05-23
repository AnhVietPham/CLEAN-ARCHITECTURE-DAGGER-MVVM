package com.avp.mvvm_tesing.domain.usecase.base.exception


class AppException(
    message: String = "",
    cause: Throwable = Throwable(),
    errorCode: Int = 0
) : Exception(message, cause)