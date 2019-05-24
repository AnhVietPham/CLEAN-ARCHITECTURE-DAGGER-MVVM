package com.avp.mvvm_tesing.data.api.remote

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteHomeApiService {
    @GET("/mod/home/top-newsfeed")
    fun getHomeTopNewsFeed(): Single<HomeTopNewFeedResponse>

    @GET("/mod/home/search-trend")
    fun getHomeSearchTrend(): Single<HomeSearchTrendResponse>

    @GET("/mod/home/recommend")
    fun getHomeRecommend(): Single<HomeRecommendResponse>

}