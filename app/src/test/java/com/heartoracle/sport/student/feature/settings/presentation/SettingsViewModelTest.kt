package com.heartoracle.sport.student.feature.settings.presentation

import com.heartoracle.sport.student.feature.settings.domain.usecase.get.GetNumberUseCase
import com.heartoracle.sport.student.core.domain.usecase.number.set.SetNumberUseCase
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito
import org.mockito.Mockito.mock

class SettingsViewModelTest {
    lateinit var getNumberUseCase: GetNumberUseCase
    lateinit var setNumberUseCase: SetNumberUseCase
    lateinit var viewModel: SettingsViewModel

    @Before
    fun setUp() {
        getNumberUseCase = mock(GetNumberUseCase::class.java)
        setNumberUseCase = mock(SetNumberUseCase::class.java)
        viewModel = SettingsViewModel(getNumberUseCase, setNumberUseCase)
        viewModel.setNumber(5)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun setNumber() {
        Mockito.verify(setNumberUseCase).number
    }
}