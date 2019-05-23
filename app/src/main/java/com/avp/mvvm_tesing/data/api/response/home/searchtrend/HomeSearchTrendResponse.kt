package com.avp.mvvm_tesing.data.api.response.home.searchtrend


import com.google.gson.annotations.SerializedName

data class HomeSearchTrendResponse(
    @SerializedName("data")
    val `data`: List<Data?>?
)