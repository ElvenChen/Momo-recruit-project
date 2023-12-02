package com.example.momo_recruit_project.exhibit

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.databinding.ViewholderAnimalDetailListBinding

class AnimalListAdapter() :
    ListAdapter<Animal, RecyclerView.ViewHolder>(AnimalListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnimalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AnimalViewHolder -> {
                val animalData = getItem(position) as Animal
                holder.bind(animalData)
//                holder.itemView.setOnClickListener {
//                    displayExhibitDetails(exhibitData)
//                }
            }
        }
    }

    class AnimalViewHolder(private val binding: ViewholderAnimalDetailListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Animal) {

            // data binding
            binding.property = item

            binding.animalAlsoKnown.text = if(item.alsoknown == ""){
                "本物種無相關別稱"
            } else {
                item.alsoknown
            }

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): AnimalViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ViewholderAnimalDetailListBinding.inflate(layoutInflater, parent, false)
                return AnimalViewHolder(binding)
            }
        }
    }

    class AnimalListDiffCallback :
        DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Animal,
            newItem: Animal
        ): Boolean {
            return oldItem == newItem
        }
    }
}