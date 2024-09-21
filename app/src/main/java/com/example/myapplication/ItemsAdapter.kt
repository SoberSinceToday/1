package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) :
    RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById<Button>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {val item = items[position]
        holder.button.text = item.text
        when (item) {
            is TxtItem -> {
                val newIcon: Drawable = context.resources.getDrawable(R.drawable.ic_doc, null)
                holder.button.setCompoundDrawablesWithIntrinsicBounds(newIcon, null, null, null)
            }

            is FolderItem -> {
                val newIcon: Drawable = context.resources.getDrawable(R.drawable.baseline_folder_24, null)
                holder.button.setCompoundDrawablesWithIntrinsicBounds(newIcon, null, null, null)
            }
        }
    }
}