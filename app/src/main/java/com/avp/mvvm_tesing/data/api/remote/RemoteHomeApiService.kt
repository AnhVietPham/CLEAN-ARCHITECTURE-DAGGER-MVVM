package com.avp.mvvm_tesing.data.api.remote

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteHomeApiService {
    @GET("mob/home/top-newsfeed")
    fun getHomeTopNewsFeed(): Single<HomeTopNewFeedResponse>

    @GET("mob/home/search-trend")
    fun getHomeSearchTrend(): Single<HomeSearchTrendResponse>

    @GET("mob/home/recommend")
    fun getHomeRecommend(): Single<HomeRecommendResponse>

}