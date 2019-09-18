package com.heartoracle.sport.student.feature.heartrate.domain.dagger

import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepositoryImpl
import com.heartoracle.sport.student.feature.heartrate.data.repository.dagger.HeartRateRepositoryModule
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.get.*
import dagger.Module
import dagger.Provides

@Module(includes = [HeartRateRepositoryModule::class])
class HeartRateUseCaseModule {

    @Provides
    fun provideGetHeartRateUseCase(repository: HeartRateRepositoryImpl): GetHeartRateUseCase =
        GetHeartRateUseCaseImpl(
            repository
        )

    @Provides
    fun provideGetSitHeartRateUseCase(repository: HeartRateRepositoryImpl): GetSitHeartRateUseCase =
        GetSitHeartRateUseCaseImpl(
            repository
        )

    @Provides
    fun provideGetStandHeartRateUseCase(repository: HeartRateRepositoryImpl): GetStandHeartRateUseCase =
        GetStandHeartRateUseCaseImpl(
            repository
        )
}