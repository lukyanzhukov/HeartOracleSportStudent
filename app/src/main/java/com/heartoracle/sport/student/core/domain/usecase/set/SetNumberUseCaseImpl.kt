package com.heartoracle.sport.student.core.domain.usecase.set

import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import javax.inject.Inject

class SetNumberUseCaseImpl @Inject constructor(private val repository: PreferenceRepository) :
    SetNumberUseCase {
    override var number: Int = -1
        set(value) {
            repository.setNumber(value)
        }
}