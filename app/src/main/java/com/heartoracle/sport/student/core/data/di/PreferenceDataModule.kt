package com.heartoracle.sport.student.core.data.di

import android.content.SharedPreferences
import com.heartoracle.sport.student.core.data.DataSource
import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import com.heartoracle.sport.student.core.domain.repository.PreferenceRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PreferenceDataModule {

    @Provides
    fun provideDataSource(preferences: SharedPreferences): DataSource =
        DataSource(preferences)

    @Provides
    fun provideRepository(dataSource: DataSource): PreferenceRepository =
        PreferenceRepositoryImpl(dataSource)
}