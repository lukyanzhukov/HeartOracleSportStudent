package com.heartoracle.sport.student.feature.heartrate.domain.model

data class OsmRes(
    val sitHeartRate: Int,
    val standHeartRate: Int,
    val zone: String,
    val score: Float
    )