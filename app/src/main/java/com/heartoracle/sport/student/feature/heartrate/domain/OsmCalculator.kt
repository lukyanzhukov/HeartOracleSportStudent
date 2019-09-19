package com.heartoracle.sport.student.feature.heartrate.domain

interface OsmCalculator {
    fun calculateScore(sitHeartRate: Int, standHeartRate: Int): Float
    fun calculateZone(score: Float): String
}

class OsmCalculatorImpl : OsmCalculator {

    override fun calculateScore(sitHeartRate: Int, standHeartRate: Int): Float {
        return (14.5 - 0.5 * ((sitHeartRate) - 40) / 3.5 - ((standHeartRate - sitHeartRate)) / 2.23 * 0.5).toFloat()
    }

    override fun calculateZone(score: Float): String {

        var sign = EMPTY_SIGN
        if (score >= 7.5) {
            sign = FIRST_SIGN
        } else if (score >= 5 && score < 7.5) {
            sign = SECOND_SIGN
        } else if (score >= 2.5 && score < 5) {
            sign = THIRD_SIGN
        } else if (score < 2.5) {
            sign = FOURTH_SIGN
        }
        return sign
    }

    companion object {
        const val EMPTY_SIGN = ""
        const val FIRST_SIGN = "I"
        const val SECOND_SIGN = "II"
        const val THIRD_SIGN = "III"
        const val FOURTH_SIGN = "IV"
    }
}