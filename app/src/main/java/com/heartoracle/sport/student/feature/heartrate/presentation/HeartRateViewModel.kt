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
    val measureHeartRate = MutableLiveData<String>()
    private val heartRateList = arrayListOf<Int>()

    init {
    }

    @SuppressLint("CheckResult")
    private fun getHeartRate() {
        getUseCase.getHeartRate().subscribe {
            measureHeartRate.value = it.toString()
            eventsDispatcher.dispatchEvent { toMeasureImage() }
        }
    }

    interface EventsListener {
        fun toMeasureImage()
        fun toOsmImage()
    }
}