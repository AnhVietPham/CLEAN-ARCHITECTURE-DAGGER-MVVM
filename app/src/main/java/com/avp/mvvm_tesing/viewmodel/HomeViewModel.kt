package com.avp.mvvm_tesing.viewmodel

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.di.ActivityScope
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor(
    private val homeRecommendUseCase: HomeRecommendUseCase,
    private val homeTopNewsFeedUseCase: HomeTopNewsFeedUseCase,
    private val homeSearchTrendUseCase: HomeSearchTrendUseCase
) {
    lateinit var homeTopNewFeedResponseResult: HomeTopNewFeedResponse
    lateinit var homeRecommendResponseResult: HomeRecommendResponse
    lateinit var homeSearchTrendResponseResult: HomeSearchTrendResponse
    fun loadHomeRecommend() {
        val homeRecommendResult = homeRecommendUseCase.loadHomeRecommend()
        homeRecommendResult.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<HomeRecommendResponse>{
                override fun onSuccess(t: HomeRecommendResponse) {
                    homeRecommendResponseResult = t
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

            })
    }

    fun loadHomeTopNewsFeed() {
        val homeTopNewsFeedResult = homeTopNewsFeedUseCase.loadHomeTopNewsFeed()
        homeTopNewsFeedResult.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<HomeTopNewFeedResponse>{
                override fun onSuccess(t: HomeTopNewFeedResponse) {
                    homeTopNewFeedResponseResult = t
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

            })

    }

    fun loadHomeSearchTrend() {
        val homeSearchTrendResult = homeSearchTrendUseCase.loadHomeSearchTrend()
        homeSearchTrendResult.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<HomeSearchTrendResponse>{
                override fun onSuccess(t: HomeSearchTrendResponse) {
                    homeSearchTrendResponseResult = t
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

            })
    }
}