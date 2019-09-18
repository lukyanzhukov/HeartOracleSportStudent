package com.heartoracle.sport.student.feature.heartrate.data.repository

import com.heartoracle.sport.student.feature.heartrate.data.firebase.FirebaseDataSource
import com.heartoracle.sport.student.feature.heartrate.domain.model.OsmRes
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface FirebaseRepository {
    fun sendToFirebase(res: OsmRes): Completable
}

class FirebaseRepositoryImpl @Inject constructor(private val dataSource: FirebaseDataSource) :
    FirebaseRepository {

    override fun sendToFirebase(res: OsmRes): Completable = dataSource.sendToFirebase(res)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}