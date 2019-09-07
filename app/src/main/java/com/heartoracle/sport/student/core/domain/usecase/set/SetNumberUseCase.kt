package com.heartoracle.sport.student.core.domain.usecase.set

import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import javax.inject.Inject

class SetNumberUseCase @Inject constructor(private val repository: PreferenceRepository) :
    SetUseCase<Int> {

    override fun setCurrent(current: Int) {
        repository.setNumber(current)
    }
}