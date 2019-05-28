package com.avp.mvvm_tesing.domain.usecase.features.home.recommend

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.failoutput.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeRecommendUseCaseTest {
    private lateinit var homeRecommendUseCase: HomeRecommendUseCase
    private var mockHomeRepository: HomeRepository = mock()
    private var mockUseCaseExecution: UseCaseExecution = mock()

    @Before
    fun setUp() {
        homeRecommendUseCase = HomeRecommendUseCase(
            homeRepository = mockHomeRepository,
            useCaseExecution = mockUseCaseExecution
        )
    }

    @Test
    fun `buildUseCaseObservable call Repository`() {
        //Arrange
        //Act
        homeRecommendUseCase.buildUseCaseObservable()
        //Assert
        verify(mockHomeRepository).getHomeRecommend()
    }

    @Test
    fun `buildUseCaseObservable complete`() {
        //Arrange
        val homeRecommendResultModels = mutableListOf<HomeRecommendResultModel>()
        whenever(mockHomeRepository.getHomeRecommend()).thenReturn(Single.just(homeRecommendResultModels))
        //Act
        val testObserver = homeRecommendUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertComplete()
    }

    @Test
    fun `buildUseCaseObservable return data`() {
        //Arrange
        val homeRecommendResultModels = mutableListOf<HomeRecommendResultModel>()
        whenever(mockHomeRepository.getHomeRecommend()).thenReturn(Single.just(homeRecommendResultModels))
        //Act
        val testObserver = homeRecommendUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertValue(homeRecommendResultModels)
    }

    @Test
    fun `createFailOutput return data`() {
        //Arrange
        val throwable = Throwable()
        //Act
        val failOutput = homeRecommendUseCase.createFailOutput(throwable)
        //Assert
        assertEquals(HomeRecommendFailOutput(throwable), failOutput)
    }
}