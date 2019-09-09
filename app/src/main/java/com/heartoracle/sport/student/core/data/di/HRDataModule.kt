package com.heartoracle.sport.student.core.data.di

import android.content.Context
import android.hardware.Sensor
import com.heartoracle.sport.student.core.data.HRDataSource
import com.heartoracle.sport.student.core.domain.repository.heartrate.HeartRateRepository
import com.heartoracle.sport.student.core.domain.repository.heartrate.HeartRateRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class HRDataModule {

    @Provides
    fun provideDataSource(context: Context, sensor: Sensor): HRDataSource =
        HRDataSource(context, sensor)

    @Provides
    fun provideRepository(dataSource: HRDataSource): HeartRateRepository =
        HeartRateRepositoryImpl(dataSource)
}