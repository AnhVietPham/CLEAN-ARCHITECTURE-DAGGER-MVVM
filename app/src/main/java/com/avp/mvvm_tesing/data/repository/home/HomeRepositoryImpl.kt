package com.avp.mvvm_tesing.data.repository.home

import android.database.Observable
import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {

    override fun getHomeTopNewsFeed(): Observable<HomeTopNewFeedResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHomeSearchTrend(): Observable<HomeSearchTrendResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHomeRecommend(): Observable<HomeRecommendResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}