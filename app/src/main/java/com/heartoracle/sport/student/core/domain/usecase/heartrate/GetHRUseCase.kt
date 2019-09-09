package com.heartoracle.sport.student.core.domain.usecase.heartrate

import com.gvillani.rxsensors.RxSensorEvent
import io.reactivex.Flowable

interface GetHRUseCase {
    val flowable: Flowable<RxSensorEvent>
}