package com.avp.mvvm_tesing

import android.app.Application
import com.avp.mvvm_tesing.di.component.AppComponent
import com.avp.mvvm_tesing.di.component.DaggerAppComponent

class App : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}