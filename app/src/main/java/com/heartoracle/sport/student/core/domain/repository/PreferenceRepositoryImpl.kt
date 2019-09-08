package com.heartoracle.sport.student.core.domain.repository

import com.heartoracle.sport.student.core.data.DataSource
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val dataSource: DataSource) :
    PreferenceRepository {

    override fun getNumber(): Int = dataSource.number

    override fun setNumber(number: Int) {
        dataSource.number = number
    }

}