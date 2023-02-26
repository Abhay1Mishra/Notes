package com.example.mynotes

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Newadaper(private val context: Context, private val linestr:IAdapyer): RecyclerView.Adapter<Newadaper.ViewHolder>() {
    private val alldata =ArrayList<Word>()
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById<TextView>(R.id.text)
        val delete: ImageView = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
        view.delete.setOnClickListener{
            linestr.onItemListner(alldata[view.adapterPosition])
        }
        return  view
    }

    override fun getItemCount(): Int {
        return alldata.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alldata =alldata[position]
        holder.text.text =alldata.text
    }
    fun  update(newList :List<Word>){
       alldata.clear()
        alldata.addAll(newList)
        notifyDataSetChanged()
    }
}

interface IAdapyer{
    fun  onItemListner(word: Word)
}