package com.heartoracle.sport.student.feature.heartrate.domain.dagger

import com.heartoracle.sport.student.feature.heartrate.domain.OsmCalculator
import com.heartoracle.sport.student.feature.heartrate.domain.OsmCalculatorImpl
import dagger.Module
import dagger.Provides

@Module
class OsmCalculatorModule() {
    @Provides
    fun provideOsmCalculator(): OsmCalculator = OsmCalculatorImpl()
}