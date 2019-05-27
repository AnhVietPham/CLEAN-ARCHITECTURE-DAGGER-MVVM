package com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.failoutput.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomeSearchTrendUseCaseTest {
    private lateinit var homeSearchTrendUseCase: HomeSearchTrendUseCase
    private var mockHomeRepository: HomeRepository = mock()
    private var mockUseCaseExecution: UseCaseExecution = mock()

    @Before
    fun setUp() {
        homeSearchTrendUseCase = HomeSearchTrendUseCase(
            homeRepository = mockHomeRepository,
            useCaseExecution = mockUseCaseExecution
        )
    }

    @Test
    fun `buildUseCaseObservable call Repository`() {
        homeSearchTrendUseCase.buildUseCaseObservable()
        verify(mockHomeRepository).getHomeSearchTrend()
    }

    @Test
    fun `buildUseCaseObservable complete`() {
        val homeSearchTrendResultModel : HomeSearchTrendResultModel = mock()
        whenever(mockHomeRepository.getHomeSearchTrend()).thenReturn(Single.just(homeSearchTrendResultModel))
        val testObserver = homeSearchTrendUseCase.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun `buildUseCaseObservable return data`() {
        val homeSearchTrendResultModel : HomeSearchTrendResultModel = mock()
        whenever(mockHomeRepository.getHomeSearchTrend()).thenReturn(Single.just(homeSearchTrendResultModel))
        val testObserver = homeSearchTrendUseCase.buildUseCaseObservable().test()
        testObserver.assertValue(homeSearchTrendResultModel)
    }

    @Test
    fun `createFailOutput return data`() {
        val throwable = Throwable()
        val failOutput = homeSearchTrendUseCase.createFailOutput(throwable)
        assertEquals(HomeSearchTrendFailOutput(throwable = throwable), failOutput)
    }
}