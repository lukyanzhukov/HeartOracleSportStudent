package com.heartoracle.sport.student.feature.heartrate.domain.usecase

import com.heartoracle.sport.student.feature.heartrate.data.repository.FirebaseRepository
import com.heartoracle.sport.student.feature.heartrate.domain.model.OsmRes
import io.reactivex.Completable
import javax.inject.Inject

interface SendToFirebaseUseCase {
    fun sendToFirebase(res: OsmRes): Completable
}

class SendToFirebaseUseCaseImpl @Inject constructor(private val repository: FirebaseRepository) :

    SendToFirebaseUseCase {
    override fun sendToFirebase(res: OsmRes): Completable = repository.sendToFirebase(res)

}