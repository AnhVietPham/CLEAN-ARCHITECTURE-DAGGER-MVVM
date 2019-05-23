package com.avp.mvvm_tesing.di.component

import com.avp.mvvm_tesing.di.module.AppModule
import com.avp.mvvm_tesing.di.module.RepoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepoModule::class])
interface AppComponent {
}