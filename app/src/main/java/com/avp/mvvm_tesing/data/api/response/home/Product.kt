package com.avp.mvvm_tesing.data.api.response.home


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("admin_id")
    val adminId: Int?,
    @SerializedName("app_dis_count_percent")
    val appDisCountPercent: Int?,
    @SerializedName("brand_id")
    val brandId: Int?,
    @SerializedName("cat_path")
    val catPath: String?,
    @SerializedName("category_id")
    val categoryId: String?,
    @SerializedName("counter_like")
    val counterLike: Int?,
    @SerializedName("counter_view")
    val counterView: Int?,
    @SerializedName("deposit_amount")
    val depositAmount: Int?,
    @SerializedName("final_price")
    val finalPrice: Int?,
    @SerializedName("final_price_max")
    val finalPriceMax: Int?,
    @SerializedName("final_promotion_percent")
    val finalPromotionPercent: Int?,
    @SerializedName("free_shipping")
    val freeShipping: Int?,
    @SerializedName("has_video")
    val hasVideo: Int?,
    @SerializedName("icon_promote")
    val iconPromote: List<String?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("img_url")
    val imgUrl: String?,
    @SerializedName("img_url_mob")
    val imgUrlMob: String?,
    @SerializedName("is_ads")
    val isAds: Int?,
    @SerializedName("is_certified")
    val isCertified: Int?,
    @SerializedName("is_config_variant")
    val isConfigVariant: Boolean?,
    @SerializedName("is_event")
    val isEvent: Int?,
    @SerializedName("is_event_frame")
    val isEventFrame: Int?,
    @SerializedName("is_product_installment")
    val isProductInstallment: Int?,
    @SerializedName("is_promotion")
    val isPromotion: Int?,
    @SerializedName("is_return_exchange_free")
    val isReturnExchangeFree: Int?,
    @SerializedName("is_second_hand")
    val isSecondHand: Int?,
    @SerializedName("is_senmall")
    val isSenmall: Int?,
    @SerializedName("loyalty_price")
    val loyaltyPrice: Int?,
    @SerializedName("min_max_price")
    val minMaxPrice: String?,
    @SerializedName("min_price")
    val minPrice: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("order_count_dd_1000_cod")
    val orderCountDd1000Cod: Int?,
    @SerializedName("original_price")
    val originalPrice: String?,
    @SerializedName("percent_star")
    val percentStar: Double?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("price_max")
    val priceMax: Int?,
    @SerializedName("product_id")
    val productId: Int?,
    @SerializedName("product_mall")
    val productMall: Int?,
    @SerializedName("promotion_note")
    val promotionNote: String?,
    @SerializedName("promotion_percent")
    val promotionPercent: Int?,
    @SerializedName("promotion_percent_upto")
    val promotionPercentUpto: String?,
    @SerializedName("shipping_supported")
    val shippingSupported: Int?,
    @SerializedName("shop_id")
    val shopId: Int?,
    @SerializedName("shop_name")
    val shopName: String?,
    @SerializedName("special_price")
    val specialPrice: Int?,
    @SerializedName("total_rated")
    val totalRated: Int?,
    @SerializedName("track_info")
    val trackInfo: String?,
    @SerializedName("url_icon_event")
    val urlIconEvent: String?
)