package com.heartoracle.sport.student.feature.settings.domain.dagger

import com.heartoracle.sport.student.core.domain.usecase.number.get.GetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.number.get.GetNumberUseCaseImpl
import com.heartoracle.sport.student.core.domain.usecase.number.set.SetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.number.set.SetNumberUseCaseImpl
import com.heartoracle.sport.student.feature.settings.data.repository.NumberRepository
import com.heartoracle.sport.student.feature.settings.data.repository.dagger.NumberRepositoryModule
import dagger.Module
import dagger.Provides

@Module(includes = [NumberRepositoryModule::class])
class NumberUseCaseModule {

    @Provides
    fun provideGetNumberUseCase(repository: NumberRepository): GetNumberUseCase =
        GetNumberUseCaseImpl(repository)

    @Provides
    fun provideSetNumberUseCase(repository: NumberRepository): SetNumberUseCase =
        SetNumberUseCaseImpl(repository)
}