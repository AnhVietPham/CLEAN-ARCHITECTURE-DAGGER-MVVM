package com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result

class HomeRecommendResultModel(
    val catPath: String,
    val categoryId: Int,
    val categoryName: String,
    val productList: List<HomeRecommendProductResultModel>,
    val rootCategoryId: Int,
    val urlPath: String
)