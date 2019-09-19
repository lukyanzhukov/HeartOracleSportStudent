package com.heartoracle.sport.student.feature.settings.domain.usecase.set

import com.heartoracle.sport.student.feature.settings.data.repository.NumberRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

class SetNumberUseCaseImplTest {

    lateinit var repository: NumberRepository

    @Before
    fun setUp() {
        repository = Mockito.mock(NumberRepository::class.java)
        repository.setNumber(5)
        repository.getNumber()
    }

    @Test
    fun getNumber() {
        repository.getNumber()
    }

    @Test
    fun setNumber() {
        repository.setNumber(5)
    }
}