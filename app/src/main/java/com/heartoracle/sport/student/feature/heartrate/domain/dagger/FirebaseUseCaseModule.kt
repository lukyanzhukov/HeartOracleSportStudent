package com.heartoracle.sport.student.feature.heartrate.domain.dagger

import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepository
import com.heartoracle.sport.student.feature.heartrate.data.repository.dagger.FirebaseRepositoryModule
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.SendToFirebaseUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.SendToFirebaseUseCaseImpl
import dagger.Module
import dagger.Provides

@Module(includes = [FirebaseRepositoryModule::class])
class FirebaseUseCaseModule {

    @Provides
    fun provideToDatabaseUseCase(repository: FirebaseRepository): SendToFirebaseUseCase =
        SendToFirebaseUseCaseImpl(repository)

}