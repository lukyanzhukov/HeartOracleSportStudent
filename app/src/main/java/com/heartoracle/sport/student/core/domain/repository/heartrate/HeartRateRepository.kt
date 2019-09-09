package com.heartoracle.sport.student.core.domain.repository.heartrate

import com.gvillani.rxsensors.RxSensorEvent
import io.reactivex.Flowable

interface HeartRateRepository {
    fun getHeartRate(): Flowable<RxSensorEvent>
}