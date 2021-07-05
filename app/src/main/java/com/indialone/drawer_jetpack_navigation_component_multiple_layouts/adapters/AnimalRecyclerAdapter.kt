package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.R
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.AnimalListItemLayoutBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.AnimalItem

class AnimalRecyclerAdapter(
    private val animals: ArrayList<AnimalItem>
) : RecyclerView.Adapter<AnimalRecyclerAdapter.AnimalRecyclerViewHolder>() {

    class AnimalRecyclerViewHolder(itemView: AnimalListItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val tvName = itemView.tvName
        private val tvAffiliation = itemView.tvAffiliation
        private val tvDob = itemView.tvDob
        private val tvDod = itemView.tvDod
        private val tvNote = itemView.tvNote
        private val tvGender = itemView.tvGender
        private val tvSpecies = itemView.tvSpecies
        private val ivAnimal = itemView.ivAnimal
        val btnMore = itemView.btnMore

        fun bind(animal: AnimalItem) {
            tvName.text = "Name: ${animal.name}"
            tvAffiliation.text = "Affiliation: ${animal.affiliation}"
            tvDob.text = "Date of Birth: ${animal.dob}"
            tvDod.text = "Date of Death: ${animal.dod}"
            tvGender.text = "Gender: ${animal.sex}"
            tvNote.text = "About: ${animal.note}"
            tvSpecies.text = "Species: ${animal.species}"

            Glide.with(itemView.context)
                .load(animal.image)
                .error(R.drawable.error_image)
                .placeholder(R.drawable.missing)
                .centerCrop()
                .into(ivAnimal)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalRecyclerViewHolder {
        val view =
            AnimalListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalRecyclerViewHolder, position: Int) {
        val animal = animals[position]
        holder.bind(animal)
        holder.btnMore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(animal.wikilink)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }

}