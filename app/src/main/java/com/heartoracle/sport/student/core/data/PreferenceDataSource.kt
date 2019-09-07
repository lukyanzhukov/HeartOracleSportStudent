package com.heartoracle.sport.student.core.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import javax.inject.Inject

class PreferenceDataSource @Inject constructor(context: Context) {

    private val preferences = context.getSharedPreferences("preferences", MODE_PRIVATE)

    fun getNumber(): Int = preferences.getInt(NUMBER_KEY, NUMBER_DEFAULT)

    fun setNumber(number: Int) {
        preferences.edit().putInt(NUMBER_KEY, number).apply()
    }

    companion object {
        const val NUMBER_KEY = "number"
        const val NUMBER_DEFAULT = 0
    }
}