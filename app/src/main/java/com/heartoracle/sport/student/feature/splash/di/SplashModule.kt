package com.heartoracle.sport.student.feature.splash.di

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import com.heartoracle.sport.student.core.domain.usecase.get.GetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.get.GetNumberUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun providePreferenceUseCase(repository: PreferenceRepository): GetNumberUseCase =
        GetNumberUseCaseImpl(repository)

}