package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendDataResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.utils.extension.valueOrEmpty
import com.avp.mvvm_tesing.utils.extension.valueOrZero
import com.avp.mvvm_tesing.utils.mapper.Mapper
import javax.inject.Inject

class HomeSearchTrendMapper @Inject constructor() : Mapper<HomeSearchTrendResponse, HomeSearchTrendResultModel>() {
    override fun map(input: HomeSearchTrendResponse): HomeSearchTrendResultModel {
        val homeSearchTrendDataResultModels = mutableListOf<HomeSearchTrendDataResultModel>()
        input.data?.forEach { item ->
            item?.let { it ->
                val homeSearchTrendDataResultModel = HomeSearchTrendDataResultModel(
                    deeplink = it.deeplink.valueOrEmpty(),
                    name = it.name.valueOrEmpty(),
                    image = it.image.valueOrEmpty(),
                    link = it.link.valueOrEmpty(),
                    q = it.q.valueOrEmpty(),
                    totalCount = it.totalCount.valueOrZero()
                )
                homeSearchTrendDataResultModels.add(homeSearchTrendDataResultModel)
            }
        }
        return HomeSearchTrendResultModel(data = homeSearchTrendDataResultModels)
    }
}