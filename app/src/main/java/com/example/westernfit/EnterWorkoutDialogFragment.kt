package com.example.westernfit

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.NumberPicker
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.time.LocalDate

interface WorkoutDialogListener {
    fun submitWorkout(date: LocalDate, workoutType: WorkoutType, duration: Int)
}

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "listener"

/**
 * A simple [Fragment] subclass.
 * Use the [EnterWorkoutDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterWorkoutDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var listener: WorkoutDialogListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_enter_workout_dialog, container, false)
        val datePicker: DatePicker = view.findViewById(R.id.datePicker)
        val workoutTypeSpinner: Spinner = view.findViewById(R.id.workout_type_spinner)
        val durationPicker: NumberPicker = view.findViewById(R.id.duration_picker)
        val okButton: Button = view.findViewById(R.id.ok_button)

        durationPicker.setMinValue(0)
        durationPicker.setMaxValue(500)

        okButton.setOnClickListener {
            Log.d("Button","OK Button Clicked")
            val date: LocalDate = LocalDate.of(datePicker.getYear(), datePicker.getMonth()+1, datePicker.getDayOfMonth())
            val workoutType: WorkoutType = WorkoutType.values().find{it.name == workoutTypeSpinner.selectedItem.toString()}?: WorkoutType.Road
            val duration = durationPicker.value
            listener?.submitWorkout(date, workoutType, durationPicker.getValue())

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EnterWorkoutDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param: WorkoutDialogListener) : EnterWorkoutDialogFragment {
            val fragment = EnterWorkoutDialogFragment().apply {
                listener = param
            }
            return fragment
        }
    }
}