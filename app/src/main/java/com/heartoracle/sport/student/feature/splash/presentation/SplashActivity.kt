package com.heartoracle.sport.student.feature.splash.presentation

import android.os.Bundle
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivitySplashBinding
import javax.inject.Inject

class SplashActivity :
    EventsActivity<ActivitySplashBinding, SplashViewModel, SplashViewModel.EventsListener>(),
    SplashViewModel.EventsListener {
    override fun nextActivity() {

    }

    override val eventsListener: SplashViewModel.EventsListener = this
    override val viewModelVariableId: Int = BR.viewModel
    @Inject
    override lateinit var viewModel: SplashViewModel

    override val layoutId = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
