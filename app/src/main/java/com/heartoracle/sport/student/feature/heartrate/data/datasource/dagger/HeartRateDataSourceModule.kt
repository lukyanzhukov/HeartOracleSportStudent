package com.heartoracle.sport.student.feature.heartrate.data.datasource.dagger

import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSource
import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface HeartRateDataSourceModule {

    @Binds
    fun bindHeartRateDataSource(impl: HeartRateDataSourceImpl): HeartRateDataSource
}