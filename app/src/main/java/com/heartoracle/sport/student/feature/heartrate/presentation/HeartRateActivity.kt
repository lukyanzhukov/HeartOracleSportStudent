package com.heartoracle.sport.student.feature.heartrate.presentation

import android.os.Bundle
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivityMeasureBinding
import javax.inject.Inject


class HeartRateActivity :
    EventsActivity<ActivityMeasureBinding, HeartRateViewModel, HeartRateViewModel.EventsListener>(),
    HeartRateViewModel.EventsListener {

    override fun nextActivity() {

    }

    override val eventsListener: HeartRateViewModel.EventsListener = this

    override val viewModelVariableId: Int = BR.viewModel

    @Inject
    override lateinit var viewModel: HeartRateViewModel

    override val layoutId = R.layout.activity_measure

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
