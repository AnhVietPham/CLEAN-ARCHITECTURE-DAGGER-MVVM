package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.topnewfeed.HomeTopNewFeedResponse
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsDataResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultChildObjectResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result.HomeTopNewsResultModel
import com.avp.mvvm_tesing.utils.extension.valueOrEmpty
import com.avp.mvvm_tesing.utils.mapper.Mapper
import javax.inject.Inject

class HomeTopNewFeedMapper @Inject constructor() : Mapper<HomeTopNewFeedResponse, HomeTopNewsResultModel>() {
    override fun map(input: HomeTopNewFeedResponse): HomeTopNewsResultModel {
        val homeTopNewsDataResultModels = mutableListOf<HomeTopNewsDataResultModel>()
        input.data?.forEach { item ->
            item?.let { it ->
                val homeTopNewsResultChildObjectResultModel =
                    HomeTopNewsResultChildObjectResultModel(topicName = it.childObject?.topicName.valueOrEmpty())
                val images = mutableListOf<String>()
                it.images?.forEach { item ->
                    images.add(item.valueOrEmpty())
                }
                val homeTopNewsDataResultModel = HomeTopNewsDataResultModel(
                    childObject = homeTopNewsResultChildObjectResultModel,
                    title = it.title.valueOrEmpty(),
                    url = it.url.valueOrEmpty(),
                    images = images
                )
                homeTopNewsDataResultModels.add(homeTopNewsDataResultModel)
            }
        }
        return HomeTopNewsResultModel(data = homeTopNewsDataResultModels, hash = input.hash.valueOrEmpty())
    }
}