package com.avp.mvvm_tesing.di.module

import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import com.avp.mvvm_tesing.data.repository.home.HomeRepositoryImpl
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeRecommendMapper
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeSearchTrendMapper
import com.avp.mvvm_tesing.data.repository.home.mapper.HomeTopNewFeedMapper
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepository(
        remoteHomeApiService: RemoteHomeApiService,
        homeRecommendMapper: HomeRecommendMapper,
        homeTopNewFeedMapper: HomeTopNewFeedMapper,
        homeSearchTrendMapper: HomeSearchTrendMapper
    ): HomeRepository {
        return HomeRepositoryImpl(
            remoteHomeApiService = remoteHomeApiService,
            homeRecommendMapper = homeRecommendMapper,
            homeSearchTrendMapper = homeSearchTrendMapper,
            homeTopNewFeedMapper = homeTopNewFeedMapper
        )
    }
}