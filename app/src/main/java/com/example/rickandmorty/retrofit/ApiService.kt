package com.example.rickandmorty.retrofit

import com.example.rickandmorty.retrofit.retrofit_model.CharacterModel
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @retrofit2.http.Query("page") page: Int,
        ): CharacterModel
}