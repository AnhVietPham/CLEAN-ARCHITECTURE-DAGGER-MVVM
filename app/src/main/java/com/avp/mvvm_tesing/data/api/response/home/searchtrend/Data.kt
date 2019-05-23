package com.avp.mvvm_tesing.data.api.response.home.searchtrend


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("deeplink")
    val deeplink: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("q")
    val q: String?,
    @SerializedName("total_count")
    val totalCount: Int?
)