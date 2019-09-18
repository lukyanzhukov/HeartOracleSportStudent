package com.heartoracle.sport.student.feature.heartrate.data.repository.dagger

import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSource
import com.heartoracle.sport.student.feature.heartrate.data.firebase.dagger.FirebaseDataSourceModule
import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepository
import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [FirebaseDataSourceModule::class])
class FirebaseRepositoryModule {

    @Provides
    fun providesFirebaseRepository(dataSource: FirebaseDataSource): FirebaseRepository =
        FirebaseRepositoryImpl(dataSource)

}