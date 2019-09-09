package com.heartoracle.sport.student.feature.settings.di

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.core.domain.repository.preference.PreferenceRepository
import com.heartoracle.sport.student.core.domain.usecase.preference.get.GetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.preference.get.GetNumberUseCaseImpl
import com.heartoracle.sport.student.core.domain.usecase.preference.set.SetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.preference.set.SetNumberUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {

    @Provides
    @ActivityScope
    fun providePreferenceGetUseCase(repository: PreferenceRepository): GetNumberUseCase =
        GetNumberUseCaseImpl(repository)

    @Provides
    @ActivityScope
    fun providePreferenceSetUseCase(repository: PreferenceRepository): SetNumberUseCase =
        SetNumberUseCaseImpl(repository)

}