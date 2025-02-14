package com.example.rickandmorty.retrofit

import com.example.rickandmorty.retrofit_model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getAllCharacters(): Call<CharacterModel>
}