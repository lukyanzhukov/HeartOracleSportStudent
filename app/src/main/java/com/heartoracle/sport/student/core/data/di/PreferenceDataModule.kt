package com.heartoracle.sport.student.core.data.di

import android.content.SharedPreferences
import com.heartoracle.sport.student.core.data.PreferenceDataSource
import com.heartoracle.sport.student.core.domain.repository.preference.PreferenceRepository
import com.heartoracle.sport.student.core.domain.repository.preference.PreferenceRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PreferenceDataModule {

    @Provides
    fun provideDataSource(preferences: SharedPreferences): PreferenceDataSource =
        PreferenceDataSource(preferences)

    @Provides
    fun provideRepository(preferenceDataSource: PreferenceDataSource): PreferenceRepository =
        PreferenceRepositoryImpl(
            preferenceDataSource
        )
}