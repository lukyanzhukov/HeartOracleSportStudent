package com.heartoracle.sport.student.feature.heartrate.domain.usecase

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

interface GetHeartRateUseCase {
    fun getHeartRate(): Flowable<RxSensorEvent>
}

class GetHeartRateUseCaseImpl @Inject constructor(private val repository: HeartRateRepository) :
    GetHeartRateUseCase {
    override fun getHeartRate(): Flowable<RxSensorEvent> =
        repository.getHeartRate().observeOn(AndroidSchedulers.mainThread())

}