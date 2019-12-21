package com.heartoracle.sport.student.feature.heartrate.data.datasource

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface HeartRateDataSource {
    fun getHeartRate(): Flowable<ArrayList<Int>>
}

class HeartRateDataSourceImpl @Inject constructor(
    private val sensor: Sensor,
    private val sensorManager: SensorManager
) : HeartRateDataSource {

    private var heartRateListener: SensorEventListener? = null

    override fun getHeartRate(): Flowable<ArrayList<Int>> = Flowable.create(
        FlowableOnSubscribe<ArrayList<Int>> {
            heartRateListener = object : SensorEventListener {

                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

                override fun onSensorChanged(event: SensorEvent?) {
                    if (event != null) {
                        if (event.sensor.type == Sensor.TYPE_HEART_RATE) {
                            it.onNext(event.values.map {
                                it.toInt()
                            } as ArrayList<Int>)
                        }
                    }
                }
            }
            sensorManager.registerListener(
                heartRateListener,
                sensor,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        },
        BackpressureStrategy.LATEST
    ).subscribeOn(Schedulers.io()).doOnCancel {
        sensorManager.unregisterListener(heartRateListener, sensor)
    }
}