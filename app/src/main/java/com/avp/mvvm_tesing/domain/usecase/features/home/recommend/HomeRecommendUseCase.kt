package com.avp.mvvm_tesing.domain.usecase.features.home.recommend

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeRecommendUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun loadHomeRecommend(): Single<HomeRecommendResponse> = homeRepository.getHomeRecommend()
}