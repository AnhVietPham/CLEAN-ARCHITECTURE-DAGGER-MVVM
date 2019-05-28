package com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed

import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.failoutput.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeTopNewsFeedUseCaseTest{
    private lateinit var homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase
    private var mockHomeRepository: HomeRepository = mock()
    private var mockUseCaseExecution: UseCaseExecution = mock()

    @Before
    fun setUp() {
        homeTopNewsFeedUseCase = HomeTopNewsFeedUseCase(
            homeRepository = mockHomeRepository,
            useCaseExecution = mockUseCaseExecution
        )
    }

    @Test
    fun `buildUseCaseObservable call Repository`() {
        //Arrange
        //Act
        homeTopNewsFeedUseCase.buildUseCaseObservable()
        //Assert
        verify(mockHomeRepository).getHomeTopNewsFeed()
    }

    @Test
    fun `buildUseCaseObservable complete`() {
        //Arrange
        val homeTopNewsResultModel : HomeTopNewsResultModel = mock()
        whenever(mockHomeRepository.getHomeTopNewsFeed()).thenReturn(Single.just(homeTopNewsResultModel))
        //Act
        val testObserver = homeTopNewsFeedUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertComplete()
    }

    @Test
    fun `buildUseCaseObservable return data`() {
        //Arrange
        val homeTopNewsResultModel : HomeTopNewsResultModel = mock()
        whenever(mockHomeRepository.getHomeTopNewsFeed()).thenReturn(Single.just(homeTopNewsResultModel))
        //Act
        val testObserver = homeTopNewsFeedUseCase.buildUseCaseObservable().test()
        //Assert
        testObserver.assertValue(homeTopNewsResultModel)
    }

    @Test
    fun `createFailOutput return data`() {
        //Arrange
        val throwable = Throwable()
        //Act
        val failOutput = homeTopNewsFeedUseCase.createFailOutput(throwable)
        //Assert
        assertEquals(HomeTopNewsFeedFailOutput(throwable = throwable), failOutput)
    }
}