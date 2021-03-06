package com.example.earthquaken

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EqAdapter : ListAdapter<Earthquake, EqAdapter.EqViewHolder>(DiffCallback)

{

    companion object DiffCallback : DiffUtil.ItemCallback<Earthquake>() {
            override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean{
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean{
                return oldItem == newItem
            }
    }

    //lateinit var onItemClickListener: (Earthquake) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_iteam, parent,false)
        return EqViewHolder(view)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val earthquake = getItem(position)
        holder.itemView.setOnClickListener()
        holder.magnitudeText.text = earthquake.magnitude.toString()
        holder.placeText.text = earthquake.place
    }

    inner class EqViewHolder(val view: View): RecyclerView.ViewHolder(view),View.OnClickListener{
            val magnitudeText = view.findViewById<TextView>(R.id.eq_magnitude_text)
            val placeText = view.findViewById<TextView>(R.id.eq_place_text)
            init{
                itemView.setOnClickListener(this)
            }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }
}