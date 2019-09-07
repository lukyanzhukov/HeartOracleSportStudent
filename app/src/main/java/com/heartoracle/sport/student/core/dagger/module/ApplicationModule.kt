package com.heartoracle.sport.student.core.dagger.module

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.feature.splash.di.SplashModule
import com.heartoracle.sport.student.feature.splash.presentation.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        PreferenceModule::class
    ]
)
interface ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [SplashModule::class]
    )
    fun SplashActivityInjector(): SplashActivity


}