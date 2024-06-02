package com.ksv.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(context: Context, textViewResourceId: Int, objects: Array<out String>) :
    ArrayAdapter<String>(context, textViewResourceId, objects) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View{

        val dayOfWeek = arrayOf( "---Понедельник", "---Вторник", "---Среда", "---Четверг",
            "Котопятница", "Субкота", "---Воскресенье" )
//        val dayOfWeek =

        val row: View = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        val lable: TextView = row.findViewById(R.id.weekofday) as TextView
        lable.text = dayOfWeek[position]


        val icon : ImageView = row.findViewById(R.id.icon) as ImageView
        if (dayOfWeek[position] == "Котопятница"
            || dayOfWeek[position] == "Субкота") {
            icon.setImageResource(R.drawable.ic_category_24);
        } else {
            icon.setImageResource(R.drawable.ic_data_usage_24);
        }
        return row;
    }
}