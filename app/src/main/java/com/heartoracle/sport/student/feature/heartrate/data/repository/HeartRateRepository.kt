package com.heartoracle.sport.student.feature.heartrate.data.repository

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSource
import io.reactivex.Flowable
import javax.inject.Inject

interface HeartRateRepository {

    fun getHeartRate(): Flowable<RxSensorEvent>
}

class HeartRateRepositoryImpl @Inject constructor(private val dataSource: HeartRateDataSource) :
    HeartRateRepository {

    override fun getHeartRate(): Flowable<RxSensorEvent> = dataSource.measureFlowable
}