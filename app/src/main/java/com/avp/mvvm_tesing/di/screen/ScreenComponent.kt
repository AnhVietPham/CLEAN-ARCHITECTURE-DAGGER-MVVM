package com.avp.mvvm_tesing.di.screen

import com.avp.mvvm_tesing.activity.home.HomeActivity
import com.avp.mvvm_tesing.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent{
    fun inject(homeActivity: HomeActivity)
}