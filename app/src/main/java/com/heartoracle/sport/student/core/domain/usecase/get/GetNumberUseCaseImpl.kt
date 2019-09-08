package com.heartoracle.sport.student.core.domain.usecase.get

import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import javax.inject.Inject

class GetNumberUseCaseImpl @Inject constructor(private val repository: PreferenceRepository) :
    GetNumberUseCase {
    override val value: Int
        get() = repository.getNumber()
}