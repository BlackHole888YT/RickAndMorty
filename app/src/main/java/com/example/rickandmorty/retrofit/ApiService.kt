package com.example.rickandmorty.retrofit

import androidx.room.Query
import com.example.rickandmorty.retrofit_model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @retrofit2.http.Query("page") page: Int,
        ): CharacterModel
}