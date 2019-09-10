package com.heartoracle.sport.student.feature.settings.presentation

import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.domain.usecase.number.get.GetNumberUseCase
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
    val number = MutableLiveData<String>()

    init {
        number.value = getUseCase.value.toString()
    }

    interface EventsListener {
        fun nextActivity()
    }
}