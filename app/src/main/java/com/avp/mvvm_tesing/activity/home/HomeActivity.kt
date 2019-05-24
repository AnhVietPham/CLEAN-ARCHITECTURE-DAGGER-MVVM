package com.avp.mvvm_tesing.activity.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.avp.mvvm_tesing.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var homeViewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}