package com.heartoracle.sport.student.feature.heartrate.data.firebase.dagger

import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSource
import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseDataSourceModule {

    @Binds
    fun bindFirebaseDataSource(impl: FirebaseDataSourceImpl): FirebaseDataSource
}