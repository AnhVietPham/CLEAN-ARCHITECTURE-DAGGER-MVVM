package com.avp.mvvm_tesing.domain.usecase.features.home

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import com.avp.mvvm_tesing.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideHomeRecommendUseCase(homeRepository: HomeRepository, useCaseExecution: UseCaseExecution) =
        HomeRecommendUseCase(
            homeRepository = homeRepository,
            useCaseExecution = useCaseExecution
        )

    @Provides
    fun provideHomeSearchTrendUseCase(homeRepository: HomeRepository, useCaseExecution: UseCaseExecution) =
        HomeSearchTrendUseCase(
            homeRepository = homeRepository,
            useCaseExecution = useCaseExecution
        )

    @Provides
    fun provideHomeTopNewsFeedUseCase(homeRepository: HomeRepository, useCaseExecution: UseCaseExecution) =
        HomeTopNewsFeedUseCase(
            homeRepository = homeRepository,
            useCaseExecution = useCaseExecution
        )

    @Provides
    fun provideHomeViewModel(
        homeRecommendUseCase: HomeRecommendUseCase,
        homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
        homeSearchTrendUseCase: HomeSearchTrendUseCase
    ) =
        HomeViewModel(
            homeTopNewsFeedUseCase = homeTopNewsFeedUseCase,
            homeSearchTrendUseCase = homeSearchTrendUseCase,
            homeRecommendUseCase = homeRecommendUseCase
        )
}