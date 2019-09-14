package com.heartoracle.sport.student.feature.heartrate.data.repository

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.core.utils.getMode
import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSourceImpl
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

interface HeartRateRepository {

    fun getSitHeartRate(): Single<Int>
    fun getStandHeartRate(): Single<Int>
    fun getHeartRate(): Flowable<Int>

}

class HeartRateRepositoryImpl @Inject constructor(private val dataSource: HeartRateDataSourceImpl) :
    HeartRateRepository {

    override fun getSitHeartRate(): Single<Int> =
        dataSource.getHeartRate().buffer(40)
            .map { t ->
                transformSitHeartRate(t)
            }.firstOrError()

    override fun getStandHeartRate(): Single<Int> =
        dataSource.getHeartRate().buffer(40)
            .map { t ->
                transformStandHeartRate(t)
            }.firstOrError()

    override fun getHeartRate(): Flowable<Int> =
        dataSource.getHeartRate().map {
            it.values.max()?.toInt()
        }

    private fun transformSitHeartRate(listEvent: List<RxSensorEvent>): Int {
        val listValues = arrayListOf<Int>()
        listEvent.forEach { event ->
            event.values.forEach { value ->
                listValues.add(value.toInt())
            }
        }
        return listValues.getMode()
    }

    private fun transformStandHeartRate(listEvent: List<RxSensorEvent>): Int? {
        val listValues = arrayListOf<Int>()
        listEvent.forEach { event ->
            event.values.forEach { value ->
                listValues.add(value.toInt())
            }
        }
        return listValues.max()
    }


}