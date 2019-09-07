package com.heartoracle.sport.student.feature.splash.presentation

import android.os.Bundle
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.BaseActivity
import com.heartoracle.sport.student.databinding.ActivitySplashBinding
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override val layoutId = R.layout.activity_splash

    override fun initBinding() {
        requireBinding().viewModel = viewModel
    }

    override fun initViewModel(state: Bundle?) {
        viewModel.onBind()
    }

}
