package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendResultModel
import com.avp.mvvm_tesing.utils.mapper.Mapper

class HomeRecommendMapper : Mapper<HomeRecommendResponse, HomeRecommendResultModel>() {
    override fun map(input: HomeRecommendResponse): HomeRecommendResultModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}