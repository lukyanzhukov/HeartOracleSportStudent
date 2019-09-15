package com.heartoracle.sport.student.feature.heartrate.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.GetHeartRateUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.GetSitHeartRateUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.GetStandHeartRateUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HeartRateViewModel @Inject constructor(
    private val getHeartRateUseCase: GetHeartRateUseCase,
    private val getSitHeartRateUseCase: GetSitHeartRateUseCase,
    private val getStandHeartRateUseCase: GetStandHeartRateUseCase
) : BaseViewModel(), EventsDispatcherOwner<HeartRateViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    val measureHeartRate = MutableLiveData<String>()
    val zone = MutableLiveData<String>()
    val result = MutableLiveData<String>()

    private var sitHeartRate: Int = 0
    private var standHeartRate: Int = 0
    private var isStandHeartRateChecked = false


    init {
        getHeartRate()
    }

    @SuppressLint("CheckResult")
    private fun getHeartRate() {
        getHeartRateUseCase.getHeartRate().subscribe {
            measureHeartRate.value = it.toString()
            if (it != 0 && isStandHeartRateChecked.not()) {
                startSitMeasure()
            }
        }
    }

    @SuppressLint("CheckResult")
    fun startSitMeasure() {
        eventsDispatcher.dispatchEvent { toMeasure() }
        isStandHeartRateChecked = true
        getSitHeartRateUseCase.getSitHeartRate().subscribe { value ->
            sitHeartRate = value
            eventsDispatcher.dispatchEvent { toStandHeartRate() }
            Single.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { it ->
                    startStandMeasure()
                }
        }
    }

    @SuppressLint("CheckResult")
    fun startStandMeasure() {
        eventsDispatcher.dispatchEvent { toMeasure() }
        getStandHeartRateUseCase.getStandHeartRate().subscribe { value ->
            standHeartRate = value
            calculateResult()
            eventsDispatcher.dispatchEvent { toResult() }
        }
    }

    fun calculateResult() {
        val points =
            (14.5 - 0.5 * ((sitHeartRate) - 40) / 3.5 - ((standHeartRate - sitHeartRate)) / 2.23 * 0.5).toFloat()
        result.value = points.toString()
        var sign = ""
        if (points >= 7.5) {
            sign = "I"
        } else if (points >= 5 && points < 7.5) {
            sign = "II"
        } else if (points >= 2.5 && points < 5) {
            sign = "III"
        } else if (points < 2.5) {
            sign = "IV"
        }
        zone.value = sign
    }

    interface EventsListener {
        fun toResult()
        fun toMeasure()
        fun toStandHeartRate()
    }
}