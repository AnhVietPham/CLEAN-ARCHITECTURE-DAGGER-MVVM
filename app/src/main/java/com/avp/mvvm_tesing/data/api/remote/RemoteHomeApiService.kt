package com.avp.mvvm_tesing.data.api.remote

import android.database.Observable
import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import retrofit2.http.GET

interface RemoteHomeApiService {
    @GET("/mod/home/top-newsfeed")
    fun getHomeTopNewsFeed(): Observable<HomeTopNewFeedResponse>

    @GET("/mod/home/search-trend")
    fun getHomeSearchTrend(): Observable<HomeSearchTrendResponse>

    @GET("/mod/home/recommend")
    fun getHomeRecommend(): Observable<HomeRecommendResponse>

}