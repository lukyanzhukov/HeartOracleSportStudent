package com.heartoracle.sport.student.feature.heartrate.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.heartoracle.sport.student.core.domain.usecase.number.get.GetNumberUseCase
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcher
import com.heartoracle.sport.student.core.presentation.eventsdispatcher.EventsDispatcherOwner
import com.heartoracle.sport.student.core.presentation.viewmodel.BaseViewModel
import com.heartoracle.sport.student.feature.heartrate.domain.OsmCalculator
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
    private val sendToFirebaseUseCase: SendToFirebaseUseCase,
    private val getNumberUseCase: GetNumberUseCase,
    private val osmCalculator: OsmCalculator
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
                .subscribe { _ ->
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
        val osmScore = osmCalculator.calculateScore(sitHeartRate, standHeartRate)
        val osmZone = osmCalculator.calculateZone(osmScore)
        score.value = osmScore.toString()
        zone.value = osmZone
        sendToFirebase(osmZone, osmScore)
    }

    @SuppressLint("CheckResult")
    private fun sendToFirebase(zone: String, score: Float) {
        sendToFirebaseUseCase.sendToFirebase(
            OsmRes(
                sitHeartRate,
                standHeartRate,
                zone,
                score,
                getNumberUseCase.number
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

    companion object {
        const val EMPTY_SIGN = ""
        const val FIRST_SIGN = "I"
        const val SECOND_SIGN = "II"
        const val THIRD_SIGN = "III"
        const val FOURTH_SIGN = "IV"
    }

}