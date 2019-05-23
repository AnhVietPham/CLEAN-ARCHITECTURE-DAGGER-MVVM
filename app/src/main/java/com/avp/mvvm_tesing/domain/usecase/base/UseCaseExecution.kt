package com.avp.mvvm_tesing.domain.usecase.base

import io.reactivex.Scheduler

class UseCaseExecution(val execution: Scheduler, val postExecution: Scheduler)