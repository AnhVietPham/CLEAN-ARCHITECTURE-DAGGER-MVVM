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
        homeRecommendUseCase.buildUseCaseObservable()
        verify(mockHomeRepository).getHomeRecommend()
    }

    @Test
    fun `buildUseCaseObservable complete`() {
        val homeRecommendResultModels = mutableListOf<HomeRecommendResultModel>()
        whenever(mockHomeRepository.getHomeRecommend()).thenReturn(Single.just(homeRecommendResultModels))
        val testObserver = homeRecommendUseCase.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun `buildUseCaseObservable return data`() {
        val homeRecommendResultModels = mutableListOf<HomeRecommendResultModel>()
        whenever(mockHomeRepository.getHomeRecommend()).thenReturn(Single.just(homeRecommendResultModels))
        val testObserver = homeRecommendUseCase.buildUseCaseObservable().test()
        testObserver.assertValue(homeRecommendResultModels)
    }

    @Test
    fun `createFailOutput return data`() {
        val throwable = Throwable()
        val failOutput = homeRecommendUseCase.createFailOutput(throwable)
        assertEquals(HomeRecommendFailOutput(throwable), failOutput)
    }
}