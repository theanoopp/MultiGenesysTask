package com.anoop.multigenesystask.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.anoop.multigenesystask.R
import com.anoop.multigenesystask.pojo.home.Subject
import kotlin.random.Random


class SubjectAdapter(private var items: List<Subject>, val context: Context) :
    RecyclerView.Adapter<SubjectAdapter.SubjectVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectVH {
        return SubjectVH(
            LayoutInflater.from(context).inflate(
                R.layout.single_subject_item,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: SubjectVH, position: Int) {

        val item = items[position]


        holder.subjectName.text = item.subjectName

        val i = Random.nextInt(0, 5)

        var color = 0

        when (i) {
            0 -> {
                color = R.drawable.subject_gradient1
            }
            1 -> {
                color = R.drawable.subject_gradient2
            }
            2 -> {
                color = R.drawable.subject_gradient3
            }
            3 -> {
                color = R.drawable.subject_gradient4
            }
            4 -> {
                color = R.drawable.subject_gradient5
            }
        }

        holder.cardView.setBackgroundResource(color)

    }


    override fun getItemCount(): Int {
        return items.size
    }


    class SubjectVH(view: View) : RecyclerView.ViewHolder(view) {
        val subjectName: TextView = view.findViewById(R.id.subject_name)
        val cardView: CardView = view.findViewById(R.id.card_view)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

}