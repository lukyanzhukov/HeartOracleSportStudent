package com.heartoracle.sport.student.core.domain.usecase.get

import com.heartoracle.sport.student.core.domain.repository.PreferenceRepository
import javax.inject.Inject

class GetNumberUseCase @Inject constructor(private val repository: PreferenceRepository) :
    GetUseCase<Int> {

    override fun getCurrent(): Int = repository.getNumber()
}