package com.avp.mvvm_tesing.viewmodel

import android.databinding.ObservableBoolean
import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.usecase.base.ResultListener
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.failoutput.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.failoutput.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRecommendUseCase: HomeRecommendUseCase,
    private val homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
    private val homeSearchTrendUseCase: HomeSearchTrendUseCase
) {
    lateinit var homeTopNewFeedResponseResult: HomeTopNewFeedResponse
    lateinit var homeRecommendResponseResults: List<HomeRecommendResponse>
    lateinit var homeSearchTrendResponseResult: HomeSearchTrendResponse
    val progressVisible = ObservableBoolean()

    fun bound() {
        loadHomeRecommend()
        loadHomeSearchTrend()
        loadHomeTopNewsFeed()
    }

    private fun loadHomeRecommend() {
        progressVisible.set(true)
        homeRecommendUseCase.executeAsync(object :
            ResultListener<List<HomeRecommendResponse>, HomeRecommendFailOutput> {
            override fun success(successOutput: List<HomeRecommendResponse>) {
                progressVisible.set(false)
                homeRecommendResponseResults = successOutput
            }

            override fun fail(failOutput: HomeRecommendFailOutput) {
                progressVisible.set(false)
            }

        })
    }

    private fun loadHomeTopNewsFeed() {
        progressVisible.set(true)
        homeTopNewsFeedUseCase.executeAsync(object : ResultListener<HomeTopNewFeedResponse, HomeTopNewsFeedFailOutput> {
            override fun success(successOutput: HomeTopNewFeedResponse) {
                progressVisible.set(false)
                homeTopNewFeedResponseResult = successOutput
            }

            override fun fail(failOutput: HomeTopNewsFeedFailOutput) {
                progressVisible.set(false)
            }
        })
    }

    private fun loadHomeSearchTrend() {
        progressVisible.set(true)
        homeSearchTrendUseCase.executeAsync(object :
            ResultListener<HomeSearchTrendResponse, HomeSearchTrendFailOutput> {
            override fun success(successOutput: HomeSearchTrendResponse) {
                progressVisible.set(false)
                homeSearchTrendResponseResult = successOutput
            }

            override fun fail(failOutput: HomeSearchTrendFailOutput) {
                progressVisible.set(false)
            }

        })
    }

}