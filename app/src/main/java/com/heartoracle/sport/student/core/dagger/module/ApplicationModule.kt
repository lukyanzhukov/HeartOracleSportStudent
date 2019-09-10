package com.heartoracle.sport.student.core.dagger.module

import com.heartoracle.sport.student.core.dagger.module.feature.HeartRateModule
import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.core.data.di.NumberDataModule
import com.heartoracle.sport.student.feature.settings.di.SettingsModule
import com.heartoracle.sport.student.feature.settings.presentation.SettingsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        PreferenceModule::class,
        HeartRateSensorModule::class,
        HeartRateModule::class,
        NumberDataModule::class
    ]
)
interface ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SettingsModule::class])
    fun SettingsActivityInjector(): SettingsActivity
}