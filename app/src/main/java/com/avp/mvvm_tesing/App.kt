package com.avp.mvvm_tesing

import android.app.Application
import com.avp.mvvm_tesing.di.component.AppComponent

class App : Application() {

    companion object {
        lateinit var component: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

    }


}
