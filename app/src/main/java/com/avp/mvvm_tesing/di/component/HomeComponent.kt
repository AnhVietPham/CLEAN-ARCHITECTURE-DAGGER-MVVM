package com.avp.mvvm_tesing.di.component

import com.avp.mvvm_tesing.di.ActivityScope
import com.avp.mvvm_tesing.di.module.HomeModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {
    fun inject()
}