package com.heartoracle.sport.student.feature.heartrate.presentation

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivityHeartrateBinding
import kotlinx.android.synthetic.main.activity_heartrate.*
import javax.inject.Inject


class HeartRateActivity :
    EventsActivity<ActivityHeartrateBinding, HeartRateViewModel, HeartRateViewModel.EventsListener>(),
    HeartRateViewModel.EventsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    override fun onBackPressed() {

    }

    override fun toResult() {
        measureView.visibility = View.GONE
        resultView.visibility = View.VISIBLE
        resultView.setOnLongClickListener {
            finish()
            true
        }
    }

    override fun toStandHeartRate() {
        measureView.visibility = View.GONE
        imageOsm.setImageResource(R.drawable.ic_stand)
        imageOsm.visibility = View.VISIBLE
    }

    override fun toMeasure() {
        imageOsm.visibility = View.GONE
        measureView.visibility = View.VISIBLE
    }

    override val eventsListener: HeartRateViewModel.EventsListener = this

    override val viewModelVariableId: Int = BR.viewModel

    @Inject
    override lateinit var viewModel: HeartRateViewModel

    override val layoutId = R.layout.activity_heartrate

}