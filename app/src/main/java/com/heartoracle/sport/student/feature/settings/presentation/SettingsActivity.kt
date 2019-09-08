package com.heartoracle.sport.student.feature.settings.presentation

import android.os.Bundle
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivitySettingsBinding
import javax.inject.Inject

class SettingsActivity :
    EventsActivity<ActivitySettingsBinding, SettingsViewModel, SettingsViewModel.EventsListener>(),
    SettingsViewModel.EventsListener {

    override fun nextActivity() {

    }

    override val eventsListener: SettingsViewModel.EventsListener = this
    override val viewModelVariableId: Int = BR.viewModel
    @Inject
    override lateinit var viewModel: SettingsViewModel

    override val layoutId = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}