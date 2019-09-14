package com.heartoracle.sport.student.feature.heartrate.presentation

import android.view.View
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivityHeartrateBinding
import kotlinx.android.synthetic.main.activity_heartrate.*
import javax.inject.Inject


class HeartRateActivity :
    EventsActivity<ActivityHeartrateBinding, HeartRateViewModel, HeartRateViewModel.EventsListener>(),
    HeartRateViewModel.EventsListener {

    override fun toOsmImage() {
        measureView.visibility = View.GONE
        osmView.visibility = View.VISIBLE
    }

    override fun toMeasureImage() {
        osmView.visibility = View.GONE
        measureView.visibility = View.VISIBLE
    }

    override val eventsListener: HeartRateViewModel.EventsListener = this

    override val viewModelVariableId: Int = BR.viewModel

    @Inject
    override lateinit var viewModel: HeartRateViewModel

    override val layoutId = R.layout.activity_heartrate

}
