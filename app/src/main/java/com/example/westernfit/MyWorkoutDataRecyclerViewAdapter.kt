package com.example.westernfit

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.westernfit.placeholder.PlaceholderContent.PlaceholderItem
import com.example.westernfit.databinding.FragmentWorkoutListBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyListItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var content: TextView = view.findViewById(R.id.content)
}

class MyWorkoutDataRecyclerViewAdapter(val values: MutableList<WorkoutData>) : RecyclerView.Adapter<MyListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_workout_list,parent, false)
        return MyListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyListItemViewHolder, position: Int) {
        holder.content.text = values[position].toString()
    }

    override fun getItemCount(): Int = values.size

}