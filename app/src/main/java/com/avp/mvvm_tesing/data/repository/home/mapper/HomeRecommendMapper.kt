package com.avp.mvvm_tesing.data.repository.home.mapper

import com.avp.mvvm_tesing.data.api.response.home.recommend.HomeRecommendResponse
import com.avp.mvvm_tesing.data.api.response.home.recommend.Product
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendProductResultModel
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.result.HomeRecommendResultModel
import com.avp.mvvm_tesing.utils.extension.valueOrEmpty
import com.avp.mvvm_tesing.utils.extension.valueOrFalse
import com.avp.mvvm_tesing.utils.extension.valueOrZero
import com.avp.mvvm_tesing.utils.mapper.Mapper
import javax.inject.Inject

class HomeRecommendMapper @Inject constructor() : Mapper<HomeRecommendResponse, HomeRecommendResultModel>() {
    override fun map(input: HomeRecommendResponse): HomeRecommendResultModel {
        val products = mutableListOf<HomeRecommendProductResultModel>()
        input.productList?.forEach { item ->
            item?.let { it ->
                products.add(mapToHomeRecommendProductResultModel(product = it))
            }
        }
        return HomeRecommendResultModel(
            catPath = input.catPath.valueOrEmpty(),
            categoryId = input.categoryId.valueOrZero(),
            categoryName = input.categoryName.valueOrEmpty(),
            rootCategoryId = input.rootCategoryId.valueOrZero(),
            urlPath = input.urlPath.valueOrEmpty(),
            productList = products
        )
    }

    private fun mapToHomeRecommendProductResultModel(product: Product): HomeRecommendProductResultModel {
        val iconPromotes = mutableListOf<String>()
        product.iconPromote?.forEach { iconPromote ->
            iconPromotes.add(iconPromote.valueOrEmpty())
        }
        return HomeRecommendProductResultModel(
            adminId = product.adminId.valueOrZero(),
            appDisCountPercent = product.appDisCountPercent.valueOrZero(),
            brandId = product.brandId.valueOrZero(),
            categoryId = product.categoryId.valueOrEmpty(),
            catPath = product.catPath.valueOrEmpty(),
            counterLike = product.counterLike.valueOrZero(),
            counterView = product.counterView.valueOrZero(),
            depositAmount = product.depositAmount.valueOrZero(),
            finalPrice = product.finalPrice.valueOrZero(),
            finalPriceMax = product.finalPriceMax.valueOrZero(),
            finalPromotionPercent = product.finalPromotionPercent.valueOrZero(),
            freeShipping = product.freeShipping.valueOrZero(),
            hasVideo = product.hasVideo.valueOrZero(),
            id = product.id.valueOrZero(),
            imgUrl = product.imgUrl.valueOrEmpty(),
            imgUrlMob = product.imgUrlMob.valueOrEmpty(),
            isCertified = product.isCertified.valueOrZero(),
            isAds = product.isAds.valueOrZero(),
            isConfigVariant = product.isConfigVariant.valueOrFalse(),
            isEvent = product.isEvent.valueOrZero(),
            isEventFrame = product.isEventFrame.valueOrZero(),
            isProductInstallment = product.isProductInstallment.valueOrZero(),
            isPromotion = product.isPromotion.valueOrZero(),
            isReturnExchangeFree = product.isReturnExchangeFree.valueOrZero(),
            isSecondHand = product.isSecondHand.valueOrZero(),
            isSenmall = product.isSenmall.valueOrZero(),
            loyaltyPrice = product.loyaltyPrice.valueOrZero(),
            minMaxPrice = product.minMaxPrice.valueOrEmpty(),
            minPrice = product.minPrice.valueOrEmpty(),
            name = product.name.valueOrEmpty(),
            orderCountDd1000Cod = product.orderCountDd1000Cod.valueOrZero(),
            originalPrice = product.originalPrice.valueOrEmpty(),
            percentStar = product.percentStar.valueOrZero(),
            price = product.price.valueOrZero(),
            priceMax = product.priceMax.valueOrZero(),
            productId = product.productId.valueOrZero(),
            productMall = product.productMall.valueOrZero(),
            promotionNote = product.promotionNote.valueOrEmpty(),
            promotionPercent = product.promotionPercent.valueOrZero(),
            promotionPercentUpto = product.promotionPercentUpto.valueOrEmpty(),
            shippingSupported = product.shippingSupported.valueOrZero(),
            shopId = product.shopId.valueOrZero(),
            shopName = product.shopName.valueOrEmpty(),
            specialPrice = product.specialPrice.valueOrZero(),
            totalRated = product.totalRated.valueOrZero(),
            trackInfo = product.trackInfo.valueOrEmpty(),
            urlIconEvent = product.urlIconEvent.valueOrEmpty(),
            iconPromote = iconPromotes
        )
    }
}