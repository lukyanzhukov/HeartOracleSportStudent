package com.heartoracle.sport.student.feature.splash.presentation

import com.heartoracle.sport.student.core.domain.usecase.get.GetUseCase
import com.heartoracle.sport.student.core.presentation.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val useCase: GetUseCase<Int>) : BaseViewModel() {

}