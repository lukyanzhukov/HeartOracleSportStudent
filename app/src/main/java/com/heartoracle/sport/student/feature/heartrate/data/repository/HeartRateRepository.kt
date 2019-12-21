package com.heartoracle.sport.student.feature.heartrate.data.repository

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

    override fun getSitHeartRate(): Single<Int> {
        return dataSource.getHeartRate()
            .buffer(30)
            .map { t ->
                transformSitHeartRate(t)
            }.firstOrError()
    }

    override fun getStandHeartRate(): Single<Int> {
        return dataSource.getHeartRate()
            .buffer(20)
            .map { t ->
                transformStandHeartRate(t)
            }.firstOrError()
    }

    override fun getHeartRate(): Flowable<Int> =
        dataSource.getHeartRate().map {
            it.max()?.toInt()
        }


    private fun transformSitHeartRate(listBuffer: List<ArrayList<Int>>): Int {
        val listValues = arrayListOf<Int>()
        listBuffer.forEach { item ->
            item.forEach { value ->
                listValues.add(value)
            }
        }
        return listValues.getMode()
    }

    private fun transformStandHeartRate(listBuffer: List<ArrayList<Int>>): Int {
        val listValues = arrayListOf<Int>()
        listBuffer.forEach { item ->
            item.forEach { value ->
                listValues.add(value)
            }
        }
        return listValues.max() ?: 0
    }


}