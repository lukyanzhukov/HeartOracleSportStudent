package com.heartoracle.sport.student.feature.measure.di

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.core.domain.repository.heartrate.HeartRateRepository
import com.heartoracle.sport.student.core.domain.usecase.heartrate.GetHRUseCase
import com.heartoracle.sport.student.core.domain.usecase.heartrate.GetHRUseCaseImpl

import dagger.Module
import dagger.Provides


@Module
class SettingsModule {

    @Provides
    @ActivityScope
    fun provideHRGetUseCase(repository: HeartRateRepository): GetHRUseCase =
        GetHRUseCaseImpl(repository)

}