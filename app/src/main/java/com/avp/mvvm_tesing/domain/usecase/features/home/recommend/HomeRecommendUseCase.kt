package com.avp.mvvm_tesing.domain.usecase.features.home.recommend

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseOutput
import io.reactivex.Single
import javax.inject.Inject

class HomeRecommendUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    useCaseExecution: UseCaseExecution
) : UseCaseOutput<List<HomeRecommendResponse>, HomeRecommendFailOutput>(useCaseExecution = useCaseExecution) {
    override fun buildUseCaseObservable(): Single<List<HomeRecommendResponse>> {
        return homeRepository.getHomeRecommend()
    }

    override fun createFailOutput(throwable: Throwable): HomeRecommendFailOutput {
        return HomeRecommendFailOutput()
    }
}