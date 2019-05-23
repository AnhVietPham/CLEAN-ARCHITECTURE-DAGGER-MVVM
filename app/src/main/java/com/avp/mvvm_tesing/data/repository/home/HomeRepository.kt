package com.avp.mvvm_tesing.data.repository.home

import android.database.Observable
import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse

interface HomeRepository {
    fun getHomeTopNewsFeed(): Observable<HomeTopNewFeedResponse>
    fun getHomeSearchTrend(): Observable<HomeSearchTrendResponse>
    fun getHomeRecommend(): Observable<HomeRecommendResponse>
}