package com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.result

class HomeTopNewsDataResultModel(
    val childObject: HomeTopNewsResultChildObjectResultModel,
    val images: List<String>,
    val title: String,
    val url: String
)