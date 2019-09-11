package com.heartoracle.sport.student.feature.settings.data.repository

import com.heartoracle.sport.student.feature.settings.data.datasource.NumberDataSource
import javax.inject.Inject

class NumberRepositoryImpl @Inject constructor(private val numberDataSource: NumberDataSource) :
    NumberRepository {

    override fun getNumber(): Int = numberDataSource.number

    override fun setNumber(number: Int) {
        numberDataSource.number = number
    }

}

interface NumberRepository {

    fun getNumber(): Int
    fun setNumber(number: Int)
}