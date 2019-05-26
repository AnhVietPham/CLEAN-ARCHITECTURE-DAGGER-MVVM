package com.avp.mvvm_tesing.data.api.response.home.topnewfeed

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("child_object")
    val childObject: ChildObject?,
    @SerializedName("images")
    val images: List<String?>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)