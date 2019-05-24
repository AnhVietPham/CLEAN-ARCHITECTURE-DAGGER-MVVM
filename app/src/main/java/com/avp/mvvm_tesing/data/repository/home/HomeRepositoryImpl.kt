package com.avp.mvvm_tesing.data.repository.home


import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import io.reactivex.Single

class HomeRepositoryImpl(private val remoteHomeApiService: RemoteHomeApiService) : HomeRepository {

    override fun getHomeTopNewsFeed(): Single<HomeTopNewFeedResponse> {
        return remoteHomeApiService.getHomeTopNewsFeed()
    }

    override fun getHomeSearchTrend(): Single<HomeSearchTrendResponse> {
        return remoteHomeApiService.getHomeSearchTrend()
    }

    override fun getHomeRecommend(): Single<HomeRecommendResponse> {
        return remoteHomeApiService.getHomeRecommend()
    }

}