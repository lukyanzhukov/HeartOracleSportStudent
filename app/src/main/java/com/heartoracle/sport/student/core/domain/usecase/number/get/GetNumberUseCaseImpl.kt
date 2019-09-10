package com.heartoracle.sport.student.core.domain.usecase.number.get

import com.heartoracle.sport.student.core.domain.repository.preference.PreferenceRepository
import javax.inject.Inject

class GetNumberUseCaseImpl @Inject constructor(private val repository: PreferenceRepository) :
    GetNumberUseCase {
    override val value: Int
        get() = repository.getNumber()
}