package com.heartoracle.sport.student.feature.heartrate.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import com.heartoracle.sport.student.feature.heartrate.domain.model.OsmRes
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.SendToFirebaseUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.get.GetHeartRateUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.get.GetSitHeartRateUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.get.GetStandHeartRateUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HeartRateViewModel @Inject constructor(
    private val getHeartRateUseCase: GetHeartRateUseCase,
    private val getSitHeartRateUseCase: GetSitHeartRateUseCase,
    private val getStandHeartRateUseCase: GetStandHeartRateUseCase,
    private val sendToFirebaseUseCase: SendToFirebaseUseCase
) : BaseViewModel(), EventsDispatcherOwner<HeartRateViewModel.EventsListener> {
    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    val measureHeartRate = MutableLiveData<String>()
    val zone = MutableLiveData<String>()
    val score = MutableLiveData<String>()

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

    private fun calculateResult() {
        val score =
            (14.5 - 0.5 * ((sitHeartRate) - 40) / 3.5 - ((standHeartRate - sitHeartRate)) / 2.23 * 0.5).toFloat()
        this.score.value = score.toString()
        var sign = ""
        if (score >= 7.5) {
            sign = "I"
        } else if (score >= 5 && score < 7.5) {
            sign = "II"
        } else if (score >= 2.5 && score < 5) {
            sign = "III"
        } else if (score < 2.5) {
            sign = "IV"
        }
        zone.value = sign
        sendToFirebase(sign, score)
    }

    @SuppressLint("CheckResult")
    private fun sendToFirebase(zone: String, score: Float) {
        sendToFirebaseUseCase.sendToFirebase(
            OsmRes(
                sitHeartRate,
                standHeartRate,
                zone,
                score
            )
        ).subscribe {
            Log.i("TAG", "success")
        }
    }

    interface EventsListener {
        fun toResult()
        fun toMeasure()
        fun toStandHeartRate()
    }
}