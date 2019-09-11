package com.heartoracle.sport.student.core.dagger.module.feature

import com.heartoracle.sport.student.core.dagger.scope.ActivityScope
import com.heartoracle.sport.student.feature.settings.domain.dagger.NumberUseCaseModule
import com.heartoracle.sport.student.feature.settings.presentation.SettingsActivity
import com.heartoracle.sport.student.feature.settings.presentation.dagger.SettingsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NumberUseCaseModule::class])
interface SettingsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SettingsActivityModule::class])
    fun SettingsActivityInjector(): SettingsActivity
}