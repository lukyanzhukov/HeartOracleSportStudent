package com.heartoracle.sport.student.feature.heartrate.data.repository.dagger

import com.heartoracle.sport.student.feature.heartrate.data.datasource.dagger.HeartRateDataSourceModule
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepository
import com.heartoracle.sport.student.feature.heartrate.data.repository.HeartRateRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [HeartRateDataSourceModule::class])
interface HeartRateRepositoryModule {

    @Binds
    fun bindHeartRateRepository(impl: HeartRateRepositoryImpl): HeartRateRepository
}