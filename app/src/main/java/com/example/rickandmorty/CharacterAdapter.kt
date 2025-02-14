package com.example.rickandmorty

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.CharacterFrameBinding
import com.example.rickandmorty.retrofit_model.Results

class CharacterAdapter(private val characters: List<Results>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    inner class CharacterViewHolder(val binding: CharacterFrameBinding): ViewHolder(binding.root) {
        fun bind(results: Results){
            binding.charName.text = results.name /// имя
            binding.charSpecies.text = results.species /// расса
            binding.charStatus.text = results.status /// жив или мёртв
            binding.charFirstSeen.text = results.origin.name /// место рождения (вроде)
            binding.charLocation.text = results.location.name /// последнеее местонахождение
            Log.e("bh", "bind: 1", )
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
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}