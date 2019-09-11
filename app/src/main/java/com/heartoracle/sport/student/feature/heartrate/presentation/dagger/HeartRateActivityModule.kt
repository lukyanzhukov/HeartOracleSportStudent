package com.heartoracle.sport.student.feature.heartrate.presentation.dagger

import androidx.lifecycle.ViewModelProvider
import com.heartoracle.sport.student.core.presentation.viewmodel.ViewModelFactory
import com.heartoracle.sport.student.feature.heartrate.domain.usecase.GetHeartRateUseCase
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateActivity
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateViewModel
import dagger.Module
import dagger.Provides

@Module
class HeartRateActivityModule {

    @Provides
    fun provideViewModel(
        context: HeartRateActivity,
        getHeartRateUseCase: GetHeartRateUseCase
    ): HeartRateViewModel = ViewModelFactory {
        HeartRateViewModel(
            getHeartRateUseCase
        )
    }.let { viewModelFactory ->
        ViewModelProvider(context, viewModelFactory)[HeartRateViewModel::class.java]
    }
}