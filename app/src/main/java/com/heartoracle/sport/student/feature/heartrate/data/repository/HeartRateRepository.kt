package com.heartoracle.sport.student.feature.heartrate.data.repository

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSourceImpl
import io.reactivex.Flowable
import javax.inject.Inject

interface HeartRateRepository {

    fun getHeartRate(): Flowable<RxSensorEvent>
}

class HeartRateRepositoryImpl @Inject constructor(private val dataSource: HeartRateDataSourceImpl) :
    HeartRateRepository {

    override fun getHeartRate(): Flowable<RxSensorEvent> = dataSource.getHeartRate()
}