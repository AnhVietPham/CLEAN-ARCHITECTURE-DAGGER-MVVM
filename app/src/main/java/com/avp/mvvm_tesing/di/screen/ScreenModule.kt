package com.avp.mvvm_tesing.di.screen

import com.avp.mvvm_tesing.view.BaseActivity
import com.avp.mvvm_tesing.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ScreenModule(private val activity: BaseActivity){
    @ActivityScope
    @Provides
    fun providesActivity() : BaseActivity{
        return activity
    }
}