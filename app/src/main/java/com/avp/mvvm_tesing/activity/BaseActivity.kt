package com.avp.mvvm_tesing.activity

import android.support.v7.app.AppCompatActivity
import com.avp.mvvm_tesing.App
import com.avp.mvvm_tesing.di.component.AppComponent
import com.avp.mvvm_tesing.di.screen.ScreenModule

open class BaseActivity : AppCompatActivity() {
    val sreenComponent by lazy {
        getApplicationComponent().plus(ScreenModule(this))
    }

    private fun getApplicationComponent(): AppComponent {
        return (application as App).component
    }
}