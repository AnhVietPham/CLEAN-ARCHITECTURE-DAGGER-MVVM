package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsResultModel
import com.avp.mvvm_tesing.utils.mapper.Mapper

class HomeTopNewFeedMapper : Mapper<HomeTopNewFeedResponse, HomeTopNewsResultModel>() {
    override fun map(input: HomeTopNewFeedResponse): HomeTopNewsResultModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}