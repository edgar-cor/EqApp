package com.example.earthquaken

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquaken.databinding.EqListIteamBinding

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

    lateinit var onItemClickListener: (Earthquake) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val binding = EqListIteamBinding.inflate(LayoutInflater.from(parent.context))
        return EqViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val earthquake = getItem(position)
        holder.bind(earthquake)

    }

    inner class EqViewHolder(val binding: EqListIteamBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(earthquake: Earthquake){
            binding.eqMagnitudeText.text = earthquake.magnitude.toString()
            binding.eqPlaceText.text = earthquake.place
            binding.root.setOnClickListener{
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(earthquake)
                }
            }
            binding.executePendingBindings()
        }
    }
}