package com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.assertEquals
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
        //Arrange
        //Act
        homeSearchTrendUseCase.buildUseCaseObservable()
        //Assert
        verify(mockHomeRepository).getHomeSearchTrend()
    }

    @Test
    fun `buildUseCaseObservable complete`() {
        //Arrange
        val homeSearchTrendResultModel : HomeSearchTrendResultModel = mock()
        whenever(mockHomeRepository.getHomeSearchTrend()).thenReturn(Single.just(homeSearchTrendResultModel))
        //Act
        val testObserver = homeSearchTrendUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertComplete()
    }

    @Test
    fun `buildUseCaseObservable return data`() {
        //Arrange
        val homeSearchTrendResultModel : HomeSearchTrendResultModel = mock()
        whenever(mockHomeRepository.getHomeSearchTrend()).thenReturn(Single.just(homeSearchTrendResultModel))
        //Act
        val testObserver = homeSearchTrendUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertValue(homeSearchTrendResultModel)
    }

    @Test
    fun `createFailOutput return data`() {
        //Arrange
        val throwable = Throwable()
        //Act
        val failOutput = homeSearchTrendUseCase.createFailOutput(throwable)
        //Assert
        assertEquals(HomeSearchTrendFailOutput(throwable = throwable), failOutput)
    }
}