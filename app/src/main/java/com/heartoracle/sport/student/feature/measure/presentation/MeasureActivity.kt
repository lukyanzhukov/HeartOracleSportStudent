package com.heartoracle.sport.student.feature.measure.presentation

import android.os.Bundle
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivityMeasureBinding
import javax.inject.Inject


class MeasureActivity :
    EventsActivity<ActivityMeasureBinding, MeasureViewModel, MeasureViewModel.EventsListener>(),
    MeasureViewModel.EventsListener {

    override fun nextActivity() {

    }

    override val eventsListener: MeasureViewModel.EventsListener = this
    override val viewModelVariableId: Int = BR.viewModel
    @Inject
    override lateinit var viewModel: MeasureViewModel

    override val layoutId = R.layout.activity_measure

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
