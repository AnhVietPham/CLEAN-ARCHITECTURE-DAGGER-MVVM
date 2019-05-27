package com.avp.mvvm_tesing.data.repository.home


import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeRecommendMapper
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeSearchTrendMapper
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeTopNewFeedMapper
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import io.reactivex.Single

class HomeRepositoryImpl(
    private val remoteHomeApiService: RemoteHomeApiService,
    private val homeRecommendMapper: HomeRecommendMapper,
    private val homeTopNewFeedMapper: HomeTopNewFeedMapper,
    private val homeSearchTrendMapper: HomeSearchTrendMapper
) : HomeRepository {

    override fun getHomeTopNewsFeed(): Single<HomeTopNewsResultModel> {
        return remoteHomeApiService.getHomeTopNewsFeed().map { homeTopNewsFeedResponse ->
            homeTopNewFeedMapper.map(input = homeTopNewsFeedResponse)
        }
    }

    override fun getHomeSearchTrend(): Single<HomeSearchTrendResultModel> {
        return remoteHomeApiService.getHomeSearchTrend().map { homeSearchTrendResponse ->
            homeSearchTrendMapper.map(input = homeSearchTrendResponse)
        }
    }

    override fun getHomeRecommend(): Single<List<HomeRecommendResultModel>> {
        return remoteHomeApiService.getHomeRecommend().map { homeRecommendResponse ->
            homeRecommendMapper.mapList(inputs = homeRecommendResponse)
        }
    }

}