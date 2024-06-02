package com.ksv.myapplication.activityresult

import java.io.Serializable

data class SettingsSet(
    val exerciseType: ExerciseType,
    val firstRange: IntRange,
    val secondRange: IntRange
): Serializable
