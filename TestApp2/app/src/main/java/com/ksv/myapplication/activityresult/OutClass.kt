package com.ksv.myapplication.activityresult

import java.io.Serializable

data class OutClass(
    val answer: String,
    val code: Int,
    val exerciseType: ExerciseType,
    val firstRange: MyIntRange
//    val secondRange: IntRange
): Serializable