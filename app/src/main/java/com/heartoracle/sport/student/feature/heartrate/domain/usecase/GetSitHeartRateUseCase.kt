package com.heartoracle.sport.student.feature.heartrate.domain.usecase

import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

interface GetSitHeartRateUseCase {
    fun getSitHeartRate(): Single<Int>
}

class GetSitHeartRateUseCaseImpl @Inject constructor(private val repository: HeartRateRepository) :
    GetSitHeartRateUseCase {

    override fun getSitHeartRate(): Single<Int> =
        repository.getSitHeartRate().observeOn(AndroidSchedulers.mainThread())

}