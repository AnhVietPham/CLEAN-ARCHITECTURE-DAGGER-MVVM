package com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.failoutput.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import io.reactivex.Single
import javax.inject.Inject

class HomeTopNewsFeedUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    useCaseExecution: UseCaseExecution
) : UseCaseOutput<HomeTopNewsResultModel, HomeTopNewsFeedFailOutput>(useCaseExecution = useCaseExecution) {
    override fun buildUseCaseObservable(): Single<HomeTopNewsResultModel> {
        return homeRepository.getHomeTopNewsFeed()
    }

    override fun createFailOutput(throwable: Throwable): HomeTopNewsFeedFailOutput {
        return HomeTopNewsFeedFailOutput()
    }
}