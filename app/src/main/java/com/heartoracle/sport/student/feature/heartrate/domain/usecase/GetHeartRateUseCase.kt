package com.heartoracle.sport.student.feature.heartrate.domain.usecase

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

interface GetHeartRateUseCase {
    val flowable: Flowable<RxSensorEvent>
}

class GetHeartRateUseCaseImpl @Inject constructor(private val repository: HeartRateRepository) :
    GetHeartRateUseCase {
    override val flowable: Flowable<RxSensorEvent>
        get() = repository.getHeartRate().observeOn(AndroidSchedulers.mainThread())
}