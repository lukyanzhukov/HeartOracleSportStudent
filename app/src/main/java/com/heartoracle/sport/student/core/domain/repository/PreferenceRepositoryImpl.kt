package com.heartoracle.sport.student.core.domain.repository

import com.heartoracle.sport.student.core.data.PreferenceDataSource
import java.lang.Exception
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val dataSource: PreferenceDataSource) :
    PreferenceRepository {

    override fun getNumber(): Int {
        val number = dataSource.getNumber()
        if (number != NUMBER_DEFAULT) {
            return number
        } else throw Exception()
    }

    override fun setNumber(number: Int) {
        dataSource.setNumber(number)
    }

    companion object {
        const val NUMBER_DEFAULT = 0
    }
}