package com.heartoracle.sport.student.core.domain.repository.preference

import com.heartoracle.sport.student.core.data.PreferenceDataSource
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val preferenceDataSource: PreferenceDataSource) :
    PreferenceRepository {

    override fun getNumber(): Int = preferenceDataSource.number

    override fun setNumber(number: Int) {
        preferenceDataSource.number = number
    }

}