package com.avp.mvvm_tesing.di.component

import com.avp.mvvm_tesing.data.api.ApiModule
import com.avp.mvvm_tesing.di.module.AppModule
import com.avp.mvvm_tesing.domain.repository.HomeRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun exposeHomeRepository(): HomeRepository
}