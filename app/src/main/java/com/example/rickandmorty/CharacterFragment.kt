package com.example.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding>() {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    private lateinit var charAdapter: CharacterAdapter

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCharacterBinding {
        return FragmentCharacterBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charAdapter = CharacterAdapter()
        binding.rvCharacter.adapter = charAdapter
        binding.rvCharacter.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getCharacters().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                charAdapter.submitData(it)
            }
        }
    }
}
