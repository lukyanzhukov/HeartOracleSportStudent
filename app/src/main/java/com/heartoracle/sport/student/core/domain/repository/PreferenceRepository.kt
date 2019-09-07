package com.heartoracle.sport.student.core.domain.repository

interface PreferenceRepository {
    fun getNumber() : Int
    fun setNumber(number: Int)
}