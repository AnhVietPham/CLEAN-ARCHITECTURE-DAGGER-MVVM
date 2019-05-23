package com.avp.mvvm_tesing.data.api.response.home.topnewfeed


import com.google.gson.annotations.SerializedName

data class HomeTopNewFeedResponse(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("hash")
    val hash: String?
)