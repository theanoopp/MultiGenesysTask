package com.anoop.multigenesystask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anoop.multigenesystask.R
import com.anoop.multigenesystask.pojo.home.University

class UniversityAdapter(private var items: List<University>, val context: Context) :
    RecyclerView.Adapter<UniversityAdapter.UniversityVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityVH {
        return UniversityVH(
            LayoutInflater.from(context).inflate(
                R.layout.single_university_item,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: UniversityVH, position: Int) {
        val item = items[position]
        holder.universityName.text = item.name
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class UniversityVH(view: View) : RecyclerView.ViewHolder(view) {
        val universityName: TextView = view.findViewById(R.id.university_name)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

}