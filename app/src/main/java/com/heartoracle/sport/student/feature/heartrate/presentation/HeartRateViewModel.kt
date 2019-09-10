package com.heartoracle.sport.student.feature.heartrate.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.GetHeartRateUseCase
import javax.inject.Inject

class HeartRateViewModel @Inject constructor(
    private val getUseCase: GetHeartRateUseCase
) : BaseViewModel(), EventsDispatcherOwner<HeartRateViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()
    val heartRate = MutableLiveData<String>()

    init {
        getHeartRate()
    }

    @SuppressLint("CheckResult")
    fun getHeartRate() {
        getUseCase.flowable.subscribe {
            it.values.forEach {
                heartRate.value = heartRate.value + it.toString()
            }
        }
    }

    private fun nextActivity() {
        eventsDispatcher.dispatchEvent {
            this@HeartRateViewModel.nextActivity()
        }
    }

    interface EventsListener {
        fun nextActivity()
    }
}