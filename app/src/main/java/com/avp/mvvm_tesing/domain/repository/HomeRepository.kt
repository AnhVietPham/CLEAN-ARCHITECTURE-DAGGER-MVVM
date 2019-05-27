package com.avp.mvvm_tesing.domain.repository

import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import io.reactivex.Single

interface HomeRepository {
    fun getHomeTopNewsFeed(): Single<HomeTopNewsResultModel>
    fun getHomeSearchTrend(): Single<HomeSearchTrendResultModel>
    fun getHomeRecommend(): Single<List<HomeRecommendResultModel>>
}