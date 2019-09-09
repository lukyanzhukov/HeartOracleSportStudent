package com.heartoracle.sport.student.core.domain.usecase.preference.set

import com.heartoracle.sport.student.core.domain.repository.preference.PreferenceRepository
import javax.inject.Inject

class SetNumberUseCaseImpl @Inject constructor(private val repository: PreferenceRepository) :
    SetNumberUseCase {
    override var number: Int = repository.getNumber()
        set(value) {
            repository.setNumber(value)
        }
}