package com.heartoracle.sport.student.core.data

import android.content.SharedPreferences
import javax.inject.Inject

class DataSource @Inject constructor(private val preferences: SharedPreferences) {

    var number: Int
        get() = preferences.getInt(
            NUMBER_KEY,
            NUMBER_DEFAULT
        )
        set(value) {
            preferences.edit().putInt(NUMBER_KEY, value).apply()
        }

    companion object {
        const val NUMBER_KEY = "number"
        const val NUMBER_DEFAULT = -1
    }
}