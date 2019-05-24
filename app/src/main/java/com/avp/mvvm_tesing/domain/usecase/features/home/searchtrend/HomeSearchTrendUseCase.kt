package com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend

import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeSearchTrendUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun loadHomeSearchTrend(): Single<HomeSearchTrendResponse> = homeRepository.getHomeSearchTrend()
}