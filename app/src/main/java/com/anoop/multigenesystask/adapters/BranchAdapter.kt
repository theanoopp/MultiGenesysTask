package com.anoop.multigenesystask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anoop.multigenesystask.R
import com.anoop.multigenesystask.glide.GlideApp
import com.anoop.multigenesystask.pojo.Branch

class BranchAdapter(private var items: List<Branch.Data>, val context: Context) :
    RecyclerView.Adapter<BranchAdapter.BranchVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchVH {
        return BranchVH(
            LayoutInflater.from(context).inflate(
                R.layout.single_branch_item,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: BranchVH, position: Int) {
        val item = items[position]
        holder.branchName.text = item.branchName
        GlideApp.with(holder.itemView).load(item.image).into(holder.image)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class BranchVH(view: View) : RecyclerView.ViewHolder(view) {
        val branchName: TextView = view.findViewById(R.id.branch_name)
        val image: ImageView = view.findViewById(R.id.branch_image)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

}