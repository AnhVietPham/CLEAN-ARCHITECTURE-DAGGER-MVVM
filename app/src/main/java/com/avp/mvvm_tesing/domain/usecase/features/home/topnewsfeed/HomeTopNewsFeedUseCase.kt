package com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed

import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeTopNewsFeedUseCase @Inject constructor(
    private val homeRepository: HomeRepository
){
    fun loadHomeTopNewsFeed() : Single<HomeTopNewFeedResponse> = homeRepository.getHomeTopNewsFeed()
}