package com.heartoracle.sport.student.core.domain.usecase.number.set

import com.heartoracle.sport.student.feature.settings.data.repository.NumberRepository
import javax.inject.Inject

interface SetNumberUseCase {
    var number: Int
}

class SetNumberUseCaseImpl @Inject constructor(private val repository: NumberRepository) :
    SetNumberUseCase {
    override var number: Int = repository.getNumber()
        set(value) {
            repository.setNumber(value)
        }
}
