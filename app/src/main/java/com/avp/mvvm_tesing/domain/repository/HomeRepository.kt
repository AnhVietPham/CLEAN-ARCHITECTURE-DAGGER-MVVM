package com.avp.mvvm_tesing.domain.repository

import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsResultModel
import io.reactivex.Single

interface HomeRepository {
    fun getHomeTopNewsFeed(): Single<HomeTopNewsResultModel>
    fun getHomeSearchTrend(): Single<HomeSearchTrendResultModel>
    fun getHomeRecommend(): Single<List<HomeRecommendResultModel>>
}