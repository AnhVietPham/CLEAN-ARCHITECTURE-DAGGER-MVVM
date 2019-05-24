package com.avp.mvvm_tesing.viewmodel

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.usecase.base.ResultListener
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRecommendUseCase: HomeRecommendUseCase,
    private val homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
    private val homeSearchTrendUseCase: HomeSearchTrendUseCase
) {
    lateinit var homeTopNewFeedResponseResult: HomeTopNewFeedResponse
    lateinit var homeRecommendResponseResults: List<HomeRecommendResponse>
    lateinit var homeSearchTrendResponseResult: HomeSearchTrendResponse

    fun bound() {
        loadHomeRecommend()
        loadHomeSearchTrend()
        loadHomeTopNewsFeed()
    }

    private fun loadHomeRecommend() {
        homeRecommendUseCase.executeAsync(object :
            ResultListener<List<HomeRecommendResponse>, HomeRecommendFailOutput> {
            override fun success(successOutput: List<HomeRecommendResponse>) {
                homeRecommendResponseResults = successOutput
            }

            override fun fail(failOutput: HomeRecommendFailOutput) {
            }

        })
    }

    private fun loadHomeTopNewsFeed() {
        homeTopNewsFeedUseCase.executeAsync(object : ResultListener<HomeTopNewFeedResponse, HomeTopNewsFeedFailOutput> {
            override fun success(successOutput: HomeTopNewFeedResponse) {
                homeTopNewFeedResponseResult = successOutput
            }

            override fun fail(failOutput: HomeTopNewsFeedFailOutput) {
            }
        })
    }

    private fun loadHomeSearchTrend() {
        homeSearchTrendUseCase.executeAsync(object :
            ResultListener<HomeSearchTrendResponse, HomeSearchTrendFailOutput> {
            override fun success(successOutput: HomeSearchTrendResponse) {
                homeSearchTrendResponseResult = successOutput
            }

            override fun fail(failOutput: HomeSearchTrendFailOutput) {
            }

        })
    }

}