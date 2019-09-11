package com.heartoracle.sport.student.feature.settings.data.datasource.dagger

import android.content.SharedPreferences
import com.heartoracle.sport.student.feature.settings.data.datasource.NumberDataSource
import com.heartoracle.sport.student.feature.settings.data.datasource.NumberDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class NumberDataSourceModule {

    @Provides
    fun provideDataSource(preferences: SharedPreferences): NumberDataSource =
        NumberDataSourceImpl(preferences)

}