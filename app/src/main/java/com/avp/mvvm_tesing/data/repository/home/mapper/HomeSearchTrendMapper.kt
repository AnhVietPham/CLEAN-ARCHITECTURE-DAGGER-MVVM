package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.searchtrend.HomeSearchTrendResponse
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.result.HomeSearchTrendResultModel
import com.avp.mvvm_tesing.utils.mapper.Mapper
import javax.inject.Inject

class HomeSearchTrendMapper @Inject constructor() : Mapper<HomeSearchTrendResponse, HomeSearchTrendResultModel>() {
    override fun map(input: HomeSearchTrendResponse): HomeSearchTrendResultModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}