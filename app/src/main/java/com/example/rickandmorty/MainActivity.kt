package com.example.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.di.AppModule
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    private lateinit var charAdapter: CharacterAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charAdapter = CharacterAdapter()
        binding.rvCharacter.adapter = charAdapter
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)

        viewModel.getCharacters().observe(this@MainActivity) {
            lifecycleScope.launch {
                charAdapter.submitData(it)
            }
        }
    }
}
