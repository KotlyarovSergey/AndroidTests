package com.ksv.myapplication.torecycle

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksv.myapplication.R

class ExerciseAdapter : RecyclerView.Adapter<ExerciseHolder>() {
    private val exerciseList = ArrayList<Exercise>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.exercise_item, parent, false)

        return ExerciseHolder(view)
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    override fun onBindViewHolder(holder: ExerciseHolder, position: Int) {
//        holder.bind(exerciseList[position])
        holder.bind(exerciseList[position], true)

        if(exerciseList[position].number1 == 0)
            holder.mark()

        if(exerciseList[position].number1 == 1)
            holder.unMark()

    }

    fun addExercise(exercise: Exercise) {
        exerciseList.add(exercise)
        notifyDataSetChanged()
        //notifyItemChanged(exerciseList.lastIndex)
        //notifyItemInserted(exerciseList.lastIndex)
    }

    fun markExercise(exercise: Exercise) {

        for (item in exerciseList) {
            if (exercise.number1 == item.number1 &&
                exercise.number2 == item.number2
            ) {
//            if(exercise == item){
                val pos = exerciseList.indexOf(item)
                Log.i("ksvlog", "Exercises found. Pos: [$pos]")
                exerciseList[pos] = Exercise(0, 0, item.sign, 0)
                notifyItemChanged(pos)
                break
            }
        }
        Log.i("ksvlog", "All exercises checked")
    }

    fun unMarkExercise(index: Int){
        //exerciseList[index] = Exercise(1,1,'-', 0)
        exerciseList[index] = Exercise(12,1,'-', 11)
        notifyItemChanged(index)
    }

    fun getItem(index: Int): Exercise? {
        if (index > 0 && index < exerciseList.size) {
            return exerciseList[index]
        }
        return null
    }

    fun clear() {
        exerciseList.clear()
        notifyDataSetChanged()
    }
}