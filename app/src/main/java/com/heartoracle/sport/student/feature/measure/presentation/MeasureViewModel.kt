package com.heartoracle.sport.student.feature.measure.presentation

import android.annotation.SuppressLint
import android.util.Log
import com.heartoracle.sport.student.core.domain.usecase.heartrate.GetHRUseCase
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class MeasureViewModel @Inject constructor(
    private val getUseCase: GetHRUseCase

) :
    BaseViewModel(),
    EventsDispatcherOwner<MeasureViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    init {
        getHeartRate()
    }

    @SuppressLint("CheckResult")
    fun getHeartRate() {
        getUseCase.flowable.subscribe {
            Log.i("TAG", it.values.toString())
        }
    }

    interface EventsListener {
        fun nextActivity()
    }
}