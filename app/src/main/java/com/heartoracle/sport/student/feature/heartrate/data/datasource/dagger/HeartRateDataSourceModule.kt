package com.heartoracle.sport.student.feature.heartrate.data.datasource.dagger

import android.content.Context
import android.hardware.Sensor
import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class HeartRateDataSourceModule {

    @Provides
    fun providesHeartRateDataSource(context: Context, sensor: Sensor): HeartRateDataSource =
        HeartRateDataSource(context, sensor)
}