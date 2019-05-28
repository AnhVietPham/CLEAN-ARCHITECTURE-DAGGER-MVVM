package com.avp.mvvm_tesing.di.component

import com.avp.mvvm_tesing.App
import com.avp.mvvm_tesing.di.module.AppModule
import com.avp.mvvm_tesing.di.module.RepositoryModule
import com.avp.mvvm_tesing.di.screen.ScreenComponent
import com.avp.mvvm_tesing.di.screen.ScreenModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plus(screen: ScreenModule): ScreenComponent
}