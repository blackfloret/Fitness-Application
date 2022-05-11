package com.example.westernfit

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

enum class WorkoutType {
    Road, Beach, Trail
}

class WorkoutData(val workOutNumber: Int, val date: LocalDate, val workoutType: WorkoutType, val duration: Int) {
    override fun toString(): String {
        return "Workout Number: $workOutNumber, Date: $date, Type: $workoutType, Duration: $duration"
    }

}