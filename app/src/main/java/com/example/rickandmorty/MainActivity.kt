package com.example.rickandmorty

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.retrofit.RetrofitInstance
import com.example.rickandmorty.retrofit_model.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    private lateinit var charAdapter: CharacterAdapter
    private val api = RetrofitInstance.api
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRv()

        viewModel.model.observe(this@MainActivity) { modelGet ->
            charAdapter.submitList(modelGet.results)
        }

        api.getAllCharacters().enqueue(object : Callback<CharacterModel> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        viewModel.getData(it)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Unknown Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage ?: "Unknown Error", Toast.LENGTH_SHORT).show()
                Log.e("bh", "onFailure: ${t.localizedMessage}")
            }
        })
    }

    private fun initRv() {
        charAdapter = CharacterAdapter(emptyList())
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        binding.rvCharacter.adapter = charAdapter
    }

}
