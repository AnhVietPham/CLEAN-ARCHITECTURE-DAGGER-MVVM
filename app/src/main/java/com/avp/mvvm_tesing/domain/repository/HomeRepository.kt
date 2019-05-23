package com.avp.mvvm_tesing.domain.repository

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import io.reactivex.Observable

interface HomeRepository {
    fun getHomeTopNewsFeed(): Observable<HomeTopNewFeedResponse>
    fun getHomeSearchTrend(): Observable<HomeSearchTrendResponse>
    fun getHomeRecommend(): Observable<HomeRecommendResponse>
}