package com.heartoracle.sport.student.feature.settings.data.datasource.dagger

import com.heartoracle.sport.student.feature.settings.data.datasource.NumberDataSource
import com.heartoracle.sport.student.feature.settings.data.datasource.NumberDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface NumberDataSourceModule {

    @Binds
    fun bindDataSource(impl: NumberDataSourceImpl): NumberDataSource

}