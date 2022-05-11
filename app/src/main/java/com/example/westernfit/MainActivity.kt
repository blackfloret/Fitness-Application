package com.example.westernfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDate

class MainActivity : AppCompatActivity(), WorkoutDialogListener {
    companion object{
        var WORKOUTDATALIST: MutableList<WorkoutData> = mutableListOf()
    }
    lateinit var addButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener {
            Log.d("Button","Add button clicked")
            val workoutDialogFragment = EnterWorkoutDialogFragment.newInstance(this)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, workoutDialogFragment, null)
                commit()
            }
            addButton.visibility = View.INVISIBLE
        }


    }

    override fun submitWorkout(date: LocalDate, workoutType: WorkoutType, duration: Int) {
        WORKOUTDATALIST.add(WorkoutData(WORKOUTDATALIST.size + 1, date, workoutType, duration))
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        Log.d("Message","Removing fragment")
        supportFragmentManager.beginTransaction().apply {
            fragment?.let {
                remove(fragment)
            }
            commit()
        }
        addButton.visibility = View.VISIBLE
        Log.d("dirk",WORKOUTDATALIST[WORKOUTDATALIST.size - 1].toString())
    }
}