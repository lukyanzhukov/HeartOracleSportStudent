package com.heartoracle.sport.student.feature.service

import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateActivity


class MainService : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val intent =
            Intent(this, HeartRateActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }


}