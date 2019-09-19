package com.heartoracle.sport.student.feature.heartrate.data.repository.dagger

import com.heartoracle.sport.student.feature.heartrate.data.firebase.dagger.FirebaseDataSourceModule
import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepository
import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseDataSourceModule::class])
interface FirebaseRepositoryModule {

    @Binds
    fun bindFirebaseRepository(impl: FirebaseRepositoryImpl): FirebaseRepository

}