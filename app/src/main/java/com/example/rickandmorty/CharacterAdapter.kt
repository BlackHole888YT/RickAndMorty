package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.CharacterFrameBinding
import com.example.rickandmorty.retrofit_model.Results

class CharacterAdapter: PagingDataAdapter<Results,CharacterAdapter.CharacterViewHolder>(DiffCallback()) {
    inner class CharacterViewHolder(val binding: CharacterFrameBinding): ViewHolder(binding.root) {
        fun bind(results: Results){
            binding.charName.text = results.name /// имя
            binding.charSpecies.text = results.species /// расса
            binding.charStatus.text = results.status /// жив или мёртв
            binding.charFirstSeen.text = results.origin.name /// место рождения (вроде)
            binding.charLocation.text = results.location.name /// последнеее местонахождение

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        val binding = CharacterFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class DiffCallback : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Results, newItem: Results) = oldItem == newItem
    }
}