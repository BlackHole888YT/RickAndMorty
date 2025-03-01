package com.example.rickandmorty.retrofit.retrofit_model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: List<Results>
)
