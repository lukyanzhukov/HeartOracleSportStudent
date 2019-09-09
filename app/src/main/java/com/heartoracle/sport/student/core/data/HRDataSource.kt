package com.heartoracle.sport.student.core.data

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


class HRDataSource @Inject constructor(
    context: Context,
    sensor: Sensor
) {
    val measureFlowable: Flowable<RxSensorEvent> = RxSensor
        .sensorEvent(context, sensor, SENSOR_DELAY_FASTEST)
        .subscribeOn(Schedulers.computation())
        .filter(RxSensorFilter.minAccuracy(SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM))
        .onBackpressureBuffer(
            128,
            { error("error") }, BackpressureOverflowStrategy.DROP_LATEST
        )
        .distinctUntilChanged(RxSensorFilter.uniqueEventValues())
        .compose(RxSensorTransformer.lowPassFilter(0.2F))
}
