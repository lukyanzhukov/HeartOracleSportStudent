package com.heartoracle.sport.student.core.dagger.module.feature

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.feature.heartrate.domain.dagger.FirebaseUseCaseModule
import com.heartoracle.sport.student.feature.heartrate.domain.dagger.HeartRateUseCaseModule
import com.heartoracle.sport.student.feature.heartrate.domain.dagger.OsmCalculatorModule
import com.heartoracle.sport.student.feature.heartrate.presentation.dagger.HeartRateActivityModule
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateActivity
import com.heartoracle.sport.student.feature.settings.domain.dagger.NumberUseCaseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HeartRateUseCaseModule::class, FirebaseUseCaseModule::class, NumberUseCaseModule::class, OsmCalculatorModule::class])
interface HeartRateModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [HeartRateActivityModule::class])
    fun heartRateActivityInjector(): HeartRateActivity

}