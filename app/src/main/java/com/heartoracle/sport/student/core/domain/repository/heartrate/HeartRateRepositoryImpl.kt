package com.heartoracle.sport.student.core.domain.repository.heartrate

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.core.data.HRDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class HeartRateRepositoryImpl @Inject constructor(private val dataSource: HRDataSource) :

    HeartRateRepository {

    override fun getHeartRate(): Flowable<RxSensorEvent> = dataSource.measureFlowable

}