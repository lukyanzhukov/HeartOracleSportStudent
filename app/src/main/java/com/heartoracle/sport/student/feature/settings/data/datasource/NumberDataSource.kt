package com.heartoracle.sport.student.feature.settings.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject

interface NumberDataSource {
    var number: Int
}

class NumberDataSourceImpl @Inject constructor(private val preferences: SharedPreferences) :
    NumberDataSource {

    override var number: Int
        get() = preferences.getInt(NUMBER_KEY, NUMBER_DEFAULT)
        set(value) {
            preferences.edit().putInt(NUMBER_KEY, value).apply()
        }

    companion object {
        const val NUMBER_KEY = "number"
        const val NUMBER_DEFAULT = -1
    }
}