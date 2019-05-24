package com.avp.mvvm_tesing.di.module

import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import com.avp.mvvm_tesing.data.repository.home.HomeRepositoryImpl
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import com.avp.mvvm_tesing.domain.usecase.base.UseCaseExecution
import com.avp.mvvm_tesing.domain.usecase.features.home.recommend.HomeRecommendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.searchtrend.HomeSearchTrendUseCase
import com.avp.mvvm_tesing.domain.usecase.features.home.topnewsfeed.HomeTopNewsFeedUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepository(remoteHomeApiService: RemoteHomeApiService): HomeRepository {
        return HomeRepositoryImpl(remoteHomeApiService = remoteHomeApiService)
    }
}