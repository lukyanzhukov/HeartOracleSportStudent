package com.heartoracle.sport.student.feature.settings.presentation

import com.heartoracle.sport.student.feature.settings.domain.usecase.get.GetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.number.set.SetNumberUseCase
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val getUseCase: GetNumberUseCase,
    private val setUseCase: SetNumberUseCase
) :
    BaseViewModel(),
    EventsDispatcherOwner<SettingsViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    init {
        eventsDispatcher.dispatchEvent { requestPermissions() }
        getNumber()
    }

    private fun getNumber() {
        eventsDispatcher.dispatchEvent {
            var number = this@SettingsViewModel.getUseCase.number
            if (number == -1) {
                number = 1
            }
            getNumber(number)
        }
    }

    fun setNumber(number: Int) {
        setUseCase.number = number
    }

    interface EventsListener {
        fun getNumber(number: Int)
        fun requestPermissions()
    }
}