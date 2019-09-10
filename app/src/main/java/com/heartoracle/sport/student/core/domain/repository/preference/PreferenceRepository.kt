package com.heartoracle.sport.student.core.domain.repository.preference

interface PreferenceRepository {

    fun getNumber() : Int
    fun setNumber(number: Int)
}