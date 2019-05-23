package com.avp.mvvm_tesing.data.api.response.home.topnewfeed


import com.google.gson.annotations.SerializedName

data class ChildObject(
    @SerializedName("topic_name")
    val topicName: String?
)