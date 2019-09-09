package com.heartoracle.sport.student.core.domain.usecase.heartrate

import com.gvillani.rxsensors.RxSensorEvent
import com.heartoracle.sport.student.core.domain.repository.heartrate.HeartRateRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GetHRUseCaseImpl @Inject constructor(private val repository: HeartRateRepository) :
    GetHRUseCase {
    override val flowable: Flowable<RxSensorEvent>
        get() = repository.getHeartRate().observeOn(AndroidSchedulers.mainThread())

}