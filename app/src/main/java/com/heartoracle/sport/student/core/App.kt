package com.heartoracle.sport.student.core

import com.heartoracle.sport.student.core.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .context(this)
            .create(this)

}
