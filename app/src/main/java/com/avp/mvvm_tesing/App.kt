package com.avp.mvvm_tesing

import android.app.Application
import com.avp.mvvm_tesing.di.component.AppComponent
import com.avp.mvvm_tesing.di.component.DaggerAppComponent
import com.avp.mvvm_tesing.di.module.AppModule

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    fun inject(){
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        component.inject(this)
    }
}
