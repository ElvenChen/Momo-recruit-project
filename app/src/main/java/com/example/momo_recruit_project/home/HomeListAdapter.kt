package com.example.momo_recruit_project.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.databinding.ViewholderAnimalExhibitListBinding

class HomeListAdapter(private val displayExhibitDetails: (Exhibit) -> Unit) :
    ListAdapter<Exhibit, RecyclerView.ViewHolder>(ExhibitListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ExhibitViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ExhibitViewHolder -> {
                val exhibitData = getItem(position) as Exhibit
                holder.bind(exhibitData)
                holder.itemView.setOnClickListener {
                    displayExhibitDetails(exhibitData)
                }
            }
        }
    }

    class ExhibitViewHolder(private val binding: ViewholderAnimalExhibitListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Exhibit) {

            // data binding
            binding.property = item

            binding.animalExhibitMemo.text = if(item.memo == ""){
                "無休館資訊"
            } else {
                item.memo
            }

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ExhibitViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ViewholderAnimalExhibitListBinding.inflate(layoutInflater, parent, false)
                return ExhibitViewHolder(binding)
            }
        }
    }

    class ExhibitListDiffCallback :
        DiffUtil.ItemCallback<Exhibit>() {
        override fun areItemsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Exhibit,
            newItem: Exhibit
        ): Boolean {
            return oldItem == newItem
        }
    }
}