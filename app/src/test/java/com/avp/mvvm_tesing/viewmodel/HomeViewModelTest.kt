package com.avp.mvvm_tesing.viewmodel

import com.avp.mvvm_tesing.domain.usecase.base.ResultListener
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.failoutput.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.failoutput.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test


class HomeViewModelTest {
    private lateinit var homeViewModel: HomeViewModel
    private var homeRecommendUseCase: HomeRecommendUseCase = mock()
    private var homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase = mock()
    private var homeSearchTrendUseCase: HomeSearchTrendUseCase = mock()

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(
            homeRecommendUseCase = homeRecommendUseCase,
            homeSearchTrendUseCase = homeSearchTrendUseCase,
            homeTopNewsFeedUseCase = homeTopNewsFeedUseCase
        )
        homeViewModel.bound()
    }

    @Test
    fun `loadHomeRecommend_01 homeRecommendUseCaseExecuteAsync success`() {
        //Arrange
        val homeRecommendResultModels = listOf<HomeRecommendResultModel>()
        val argumentCaptor = argumentCaptor<ResultListener<List<HomeRecommendResultModel>, HomeRecommendFailOutput>>()
        //Act
        verify(homeRecommendUseCase).executeAsync(argumentCaptor.capture())
        //Assert
        argumentCaptor.firstValue.success(homeRecommendResultModels)
    }

    @Test
    fun `loadHomeRecommend_02 homeRecommendUseCaseExecuteAsync failure`() {
        //Arrange
        val homeRecommendFailOutput: HomeRecommendFailOutput = mock()
        val argumentCaptor = argumentCaptor<ResultListener<List<HomeRecommendResultModel>, HomeRecommendFailOutput>>()
        //Act
        verify(homeRecommendUseCase).executeAsync(argumentCaptor.capture())
        //Assert
        argumentCaptor.firstValue.fail(homeRecommendFailOutput)
    }

    @Test
    fun `loadHomeTopNewsFeed_01 homeTopNewsFeedUseCaseExecuteAsync success`() {
        //Arrange
        val homeTopNewsResultModel: HomeTopNewsResultModel = mock()
        val argumentCaptor = argumentCaptor<ResultListener<HomeTopNewsResultModel, HomeTopNewsFeedFailOutput>>()
        //Act
        verify(homeTopNewsFeedUseCase).executeAsync(argumentCaptor.capture())
        //Assert
        argumentCaptor.firstValue.success(homeTopNewsResultModel)
    }

    @Test
    fun `loadHomeTopNewsFeed_02 homeTopNewsFeedUseCaseExecuteAsync failure`() {
//        //Arrange
//        val homeTopNewsFeedFailOutput: HomeTopNewsFeedFailOutput = mock()
//        val argumentCaptor = argumentCaptor<ResultListener<HomeTopNewsResultModel, HomeTopNewsFeedFailOutput>>()
//        //Act
//        verify(homeTopNewsFeedUseCase).executeAsync(argumentCaptor.capture())
//        //Assert
//        argumentCaptor.firstValue.fail(homeTopNewsFeedFailOutput)
    }

    @Test
    fun `loadHomeSearchTrend_01 homeSearchTrendUseCaseExecuteAsync success`() {
        //Arrange
        val homeSearchTrendResultModel: HomeSearchTrendResultModel = mock()
        val argumentCaptor = argumentCaptor<ResultListener<HomeSearchTrendResultModel, HomeSearchTrendFailOutput>>()
        //Act
        verify(homeSearchTrendUseCase).executeAsync(argumentCaptor.capture())
        //Assert
        argumentCaptor.firstValue.success(homeSearchTrendResultModel)
    }

    @Test
    fun `loadHomeSearchTrend_02 homeSearchTrendUseCaseExecuteAsync failure`() {
        //Arrange
        val homeSearchTrendFailOutput: HomeSearchTrendFailOutput = mock()
        val argumentCaptor = argumentCaptor<ResultListener<HomeSearchTrendResultModel, HomeSearchTrendFailOutput>>()
        //Act
        verify(homeSearchTrendUseCase).executeAsync(argumentCaptor.capture())
        //Assert
        argumentCaptor.firstValue.fail(homeSearchTrendFailOutput)
    }
}