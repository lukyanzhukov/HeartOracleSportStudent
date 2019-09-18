package com.heartoracle.sport.student.feature.heartrate.data.firebase

import android.annotation.SuppressLint
import com.google.firebase.database.DatabaseReference
import com.heartoracle.sport.student.feature.heartrate.domain.model.OsmRes
import io.reactivex.Completable
import javax.inject.Inject

interface FirebaseDataSource {
    fun sendToFirebase(res: OsmRes): Completable
}

class FirebaseDataSourceImpl @Inject constructor(private val databaseReference: DatabaseReference) :
    FirebaseDataSource {

    @SuppressLint("CheckResult")
    override fun sendToFirebase(res: OsmRes): Completable =
        Completable.create {
            val key = databaseReference.child("test").push().key as String
            databaseReference.child("test").child(key).setValue(
                res
            ) { databaseError, _ ->
                if (it.isDisposed) {
                    return@setValue
                }
                if (databaseError == null) {
                    it.onComplete()
                } else {
                    it.onError(Throwable(databaseError.message))
                }
            }
        }


}