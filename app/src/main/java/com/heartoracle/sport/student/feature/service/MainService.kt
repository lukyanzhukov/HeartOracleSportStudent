package com.heartoracle.sport.student.feature.service

import android.annotation.TargetApi
import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.heartoracle.sport.student.feature.settings.presentation.SettingsActivity
import android.os.Build



class MainService : FirebaseMessagingService() {


    @TargetApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i("TAG", "message!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        val intent =
            Intent(this, SettingsActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }


}