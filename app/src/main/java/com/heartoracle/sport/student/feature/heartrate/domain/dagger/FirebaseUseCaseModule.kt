package com.heartoracle.sport.student.feature.heartrate.domain.dagger

import com.heartoracle.sport.student.feature.heartrate.data.repository.dagger.FirebaseRepositoryModule
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.SendToFirebaseUseCase
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.SendToFirebaseUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseRepositoryModule::class])
interface FirebaseUseCaseModule {

    @Binds
    fun bindToDatabaseUseCase(impl: SendToFirebaseUseCaseImpl): SendToFirebaseUseCase

}