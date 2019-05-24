package com.avp.mvvm_tesing.domain.repository

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import io.reactivex.Single

interface HomeRepository {
    fun getHomeTopNewsFeed(): Single<HomeTopNewFeedResponse>
    fun getHomeSearchTrend(): Single<HomeSearchTrendResponse>
    fun getHomeRecommend(): Single<HomeRecommendResponse>
}