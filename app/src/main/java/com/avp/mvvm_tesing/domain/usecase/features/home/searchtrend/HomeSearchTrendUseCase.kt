package com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import io.reactivex.Single
import javax.inject.Inject

class HomeSearchTrendUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    useCaseExecution: UseCaseExecution
) : UseCaseOutput<HomeSearchTrendResultModel, HomeSearchTrendFailOutput>(useCaseExecution = useCaseExecution) {
    override fun buildUseCaseObservable(): Single<HomeSearchTrendResultModel> {
        return homeRepository.getHomeSearchTrend()
    }

    override fun createFailOutput(throwable: Throwable): HomeSearchTrendFailOutput {
        return HomeSearchTrendFailOutput(throwable = throwable)
    }
}