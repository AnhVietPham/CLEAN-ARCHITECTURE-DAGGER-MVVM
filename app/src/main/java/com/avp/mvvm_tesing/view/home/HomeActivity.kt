package com.avp.mvvm_tesing.view.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.avp.mvvm_tesing.R
import com.avp.mvvm_tesing.view.BaseActivity
import com.avp.mvvm_tesing.databinding.ActivityHomeBinding
import com.avp.mvvm_tesing.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeActivityBinding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.activity_home
        )
        sreenComponent.inject(this)
        homeActivityBinding.homeViewModel = homeViewModel
        homeViewModel.bound()
    }
}