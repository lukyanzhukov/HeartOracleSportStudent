package com.heartoracle.sport.student.feature.heartrate.data.datasource

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_FASTEST
import javax.inject.Inject
import com.gvillani.rxsensors.RxSensor
import com.gvillani.rxsensors.RxSensorEvent
import com.gvillani.rxsensors.RxSensorFilter
import com.gvillani.rxsensors.RxSensorTransformer
import io.reactivex.BackpressureOverflowStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

interface HeartRateDataSource {
    fun getHeartRate(): Flowable<RxSensorEvent>
}

class HeartRateDataSourceImpl @Inject constructor(
    val context: Context,
    val sensor: Sensor
) : HeartRateDataSource {
    override fun getHeartRate(): Flowable<RxSensorEvent> = RxSensor
        .sensorEvent(context, sensor, SENSOR_DELAY_FASTEST)
        .subscribeOn(Schedulers.computation())
        .filter(RxSensorFilter.minAccuracy(SensorManager.SENSOR_STATUS_ACCURACY_HIGH))
        .onBackpressureBuffer(
            BUFFER_CAPACITY,
            {}, BackpressureOverflowStrategy.DROP_LATEST
        )
        .distinctUntilChanged(RxSensorFilter.uniqueEventValues())
        .compose(RxSensorTransformer.lowPassFilter(LPF_SETTINGS))

    companion object {
        const val BUFFER_CAPACITY = 128L
        const val LPF_SETTINGS = 0.2F
    }
}