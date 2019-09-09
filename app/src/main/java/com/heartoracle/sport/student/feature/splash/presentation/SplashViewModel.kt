package com.heartoracle.sport.student.feature.splash.presentation

import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.domain.usecase.preference.get.GetNumberUseCase
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val useCase: GetNumberUseCase) :
    BaseViewModel(),
    EventsDispatcherOwner<SplashViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()
    val number = MutableLiveData<String>()

    init {
        number.value = useCase.value.toString()
    }

    interface EventsListener {
        fun nextActivity()
    }
}