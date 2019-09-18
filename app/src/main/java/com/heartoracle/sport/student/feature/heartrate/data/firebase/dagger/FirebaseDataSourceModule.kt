package com.heartoracle.sport.student.feature.heartrate.data.firebase.dagger

import com.google.firebase.database.DatabaseReference
import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSource
import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class FirebaseDataSourceModule {

    @Provides
    fun provideFirebaseDataSource(databaseReference: DatabaseReference): FirebaseDataSource =
        FirebaseDataSourceImpl(databaseReference)
}