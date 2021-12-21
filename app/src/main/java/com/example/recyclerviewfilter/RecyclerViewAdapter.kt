package com.example.recyclerviewfilter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RecyclerViewAdapter(context: Context, list: ArrayList<list>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(), Filterable {

    private var context: Context? = context
    var unFilteredList: ArrayList<list>? = list
    var filteredList: ArrayList<list>? = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = filteredList!![position].name
        holder.textView1.text = filteredList!![position].friend

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }

    interface OnItemClickListener{
        fun onClick(v:View,position: Int)
    }
    private lateinit var itemClickListener: OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun getItemCount(): Int {
        return filteredList!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById<View>(R.id.textview) as TextView
        var textView1: TextView = itemView.findViewById(R.id.textview1)

    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                if (charString.isEmpty()) {
                    filteredList = unFilteredList
                } else {
                    val filteringList = ArrayList<list>()
                    for (i in unFilteredList!!.indices) {
                        val name = unFilteredList!![i].name
                        val friend = unFilteredList!![i].friend
                        val data = list()
                        data.name = name
                        data.friend = friend
                        if (name!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(data)
                        }
                    }
                    filteredList = filteringList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                filteredList = results.values as ArrayList<list>
                notifyDataSetChanged()
            }
        }
    }


}
