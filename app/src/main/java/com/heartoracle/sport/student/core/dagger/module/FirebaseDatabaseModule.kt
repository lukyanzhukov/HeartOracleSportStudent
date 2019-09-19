package com.heartoracle.sport.student.core.dagger.module

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides

@Module
class FirebaseDatabaseModule {

    @Provides
    fun provideDatabaseReference(): DatabaseReference = FirebaseDatabase.getInstance().reference

}