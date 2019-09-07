package com.heartoracle.sport.student.core.dagger.module

import android.content.Context
import com.heartoracle.sport.student.core.data.PreferenceDataSource
import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import com.heartoracle.sport.student.core.domain.repository.PreferenceRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PreferenceModule {

    @Provides
    fun providePreferenceDataSource(context: Context): PreferenceDataSource =
        PreferenceDataSource(context)

    @Provides
    fun providePreferenceRepository(dataSource: PreferenceDataSource): PreferenceRepository =
        PreferenceRepositoryImpl(dataSource)
}