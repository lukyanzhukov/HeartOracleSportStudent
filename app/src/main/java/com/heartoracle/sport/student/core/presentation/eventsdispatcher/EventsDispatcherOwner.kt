package com.heartoracle.sport.student.core.presentation.eventsdispatcher

interface EventsDispatcherOwner<T> {
    val eventsDispatcher: EventsDispatcher<T>
}