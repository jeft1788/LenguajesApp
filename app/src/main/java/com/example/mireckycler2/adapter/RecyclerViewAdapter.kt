package com.example.mireckycler2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mireckycler2.DetailsActivity
import com.example.mireckycler2.R
import com.example.mireckycler2.model.RecyclerData


class RecyclerViewAdapter(

    private val context: Context, private var dataset: List<RecyclerData>):
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){
    class RecyclerViewHolder(private val view: View):
        RecyclerView.ViewHolder(view) {
            val courseTV: TextView = view.findViewById(R.id.txt)
            val courseIV : ImageView = view.findViewById(R.id.imgv)
            val linearLayout: LinearLayout = view.findViewById(R.id.item)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).
        inflate(R.layout.card_layout, parent, false)
        return RecyclerViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerData = dataset[position]
        holder.courseTV.text = context.resources.getString(recyclerData.stringResourceId)
        holder.courseIV.setImageResource(recyclerData.imageResourceId)
        holder.linearLayout.setOnClickListener(){
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("image",recyclerData.imageResourceId)
            intent.putExtra("name", context.resources.getString(recyclerData.stringResourceId))

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }

    fun filterList(filterlist: List<RecyclerData>) {
        // below line is to add our filtered
        // list in our course array list.
        dataset = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }
    fun actualizar(miLista: ArrayList<RecyclerData>){
        this.dataset = miLista
        notifyDataSetChanged()
    }
    /*fun filter(){
        dataset.filter {  recyclerData -> recyclerData.equals()

        }
    }*/
}