package com.heartoracle.sport.student.feature.heartrate.data.repository.dagger

import com.heartoracle.sport.student.feature.heartrate.data.datasource.HeartRateDataSource
import com.heartoracle.sport.student.feature.heartrate.data.datasource.dagger.HeartRateDataSourceModule
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepository
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [HeartRateDataSourceModule::class])
class HeartRateRepositoryModule {

    @Provides
    fun providesHeartRateRepository(dataSource: HeartRateDataSource): HeartRateRepository =
        HeartRateRepositoryImpl(dataSource)
}