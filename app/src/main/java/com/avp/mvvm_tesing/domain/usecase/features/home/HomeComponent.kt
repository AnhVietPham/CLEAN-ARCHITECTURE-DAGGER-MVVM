package com.avp.mvvm_tesing.domain.usecase.features.home

import com.avp.mvvm_tesing.activity.home.HomeActivity
import com.avp.mvvm_tesing.di.ActivityScope
import com.avp.mvvm_tesing.di.component.AppComponent
import dagger.Component

@ActivityScope
@Component(modules = [HomeModule::class],
    dependencies = [AppComponent::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}