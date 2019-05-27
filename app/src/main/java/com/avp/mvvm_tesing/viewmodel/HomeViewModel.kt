package com.avp.mvvm_tesing.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import com.avp.mvvm_tesing.domain.usecase.base.ResultListener
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.failoutput.HomeRecommendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.failoutput.HomeSearchTrendFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendDataResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.failoutput.HomeTopNewsFeedFailOutput
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsDataResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRecommendUseCase: HomeRecommendUseCase,
    private val homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
    private val homeSearchTrendUseCase: HomeSearchTrendUseCase
) {
    val homeTopNewFeedResult = ObservableArrayList<HomeTopNewsDataResultModel>()
    val homeRecommendResults = ObservableArrayList<HomeRecommendResultModel>()
    val homeSearchTrendResult = ObservableArrayList<HomeSearchTrendDataResultModel>()
    val progressVisible = ObservableBoolean()

    fun bound() {
        progressVisible(isVisible = true)
        loadHomeRecommend()
        loadHomeSearchTrend()
        loadHomeTopNewsFeed()
    }

    private fun loadHomeRecommend() {
        homeRecommendUseCase.executeAsync(object :
            ResultListener<List<HomeRecommendResultModel>, HomeRecommendFailOutput> {
            override fun success(successOutput: List<HomeRecommendResultModel>) {
                progressVisible(isVisible = false)
                homeRecommendResults.addAll(successOutput)
            }

            override fun fail(failOutput: HomeRecommendFailOutput) {
                progressVisible.set(false)
            }

        })
    }

    private fun loadHomeTopNewsFeed() {
        homeTopNewsFeedUseCase.executeAsync(object : ResultListener<HomeTopNewsResultModel, HomeTopNewsFeedFailOutput> {
            override fun success(successOutput: HomeTopNewsResultModel) {
                progressVisible(isVisible = false)
                homeTopNewFeedResult.addAll(successOutput.data)
            }

            override fun fail(failOutput: HomeTopNewsFeedFailOutput) {
                progressVisible.set(false)
            }
        })
    }

    private fun loadHomeSearchTrend() {
        homeSearchTrendUseCase.executeAsync(object :
            ResultListener<HomeSearchTrendResultModel, HomeSearchTrendFailOutput> {
            override fun success(successOutput: HomeSearchTrendResultModel) {
                progressVisible(isVisible = false)
                homeSearchTrendResult.addAll(successOutput.data)
            }

            override fun fail(failOutput: HomeSearchTrendFailOutput) {
                progressVisible.set(false)
            }

        })
    }

    private fun progressVisible(isVisible: Boolean) {
        progressVisible.set(isVisible)
    }
}