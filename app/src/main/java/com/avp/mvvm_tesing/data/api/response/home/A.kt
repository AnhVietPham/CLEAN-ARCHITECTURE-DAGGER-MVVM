package com.avp.mvvm_tesing.data.api.response.home


import com.google.gson.annotations.SerializedName

data class A(
    @SerializedName("cat_path")
    val catPath: String?,
    @SerializedName("category_id")
    val categoryId: Int?,
    @SerializedName("category_name")
    val categoryName: String?,
    @SerializedName("product_list")
    val productList: List<Product?>?,
    @SerializedName("root_category_id")
    val rootCategoryId: Int?,
    @SerializedName("url_path")
    val urlPath: String?
)