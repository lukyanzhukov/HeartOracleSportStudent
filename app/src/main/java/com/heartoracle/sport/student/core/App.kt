package com.heartoracle.sport.student.core

import com.google.firebase.messaging.FirebaseMessaging
import com.heartoracle.sport.student.core.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .context(this)
            .create(this)

    companion object {
        const val TOPIC = "all"
    }
}
