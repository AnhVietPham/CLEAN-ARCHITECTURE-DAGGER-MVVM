package com.avp.mvvm_tesing.viewmodel

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.di.ActivityScope
import com.avp.mvvm_tesing.domain.usecase.base.ResultListener
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor(
    private val homeRecommendUseCase: HomeRecommendUseCase,
    private val homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
    private val homeSearchTrendUseCase: HomeSearchTrendUseCase
) {
    fun loadHomeRecommend(){
        homeRecommendUseCase.executeAsync(object : ResultListener<HomeRecommendResponse,HomeRecommendFailOutput>{
            override fun success(successOutput: HomeRecommendResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun fail(failOutput: HomeRecommendFailOutput) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    fun loadHomeTopNewsFeed(){
        homeTopNewsFeedUseCase.executeAsync(object : ResultListener<HomeTopNewFeedResponse,HomeTopNewsFeedFailOutput>{
            override fun success(successOutput: HomeTopNewFeedResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun fail(failOutput: HomeTopNewsFeedFailOutput) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    fun loadHomeSearchTrend(){
        homeSearchTrendUseCase.executeAsync(object : ResultListener<HomeSearchTrendResponse,HomeSearchTrendFailOutput>{
            override fun success(successOutput: HomeSearchTrendResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun fail(failOutput: HomeSearchTrendFailOutput) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}