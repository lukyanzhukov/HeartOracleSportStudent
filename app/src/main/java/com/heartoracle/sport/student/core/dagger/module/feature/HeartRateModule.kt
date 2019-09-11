package com.heartoracle.sport.student.core.dagger.module.feature

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.feature.heartrate.domain.dagger.HeartRateUseCaseModule
import com.heartoracle.sport.student.feature.heartrate.presentation.dagger.HeartRateActivityModule
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HeartRateUseCaseModule::class])
interface HeartRateModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [HeartRateActivityModule::class])
    fun heartRateActivityInjector(): HeartRateActivity
}