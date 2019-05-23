package com.avp.mvvm_tesing.domain.usecase.base.exception

import java.lang.RuntimeException

class AppRuntimeException(
    message: String = "",
    cause: Throwable = Throwable()
) : RuntimeException(message, cause)