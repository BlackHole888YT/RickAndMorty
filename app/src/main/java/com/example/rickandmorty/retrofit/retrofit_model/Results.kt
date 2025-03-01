package com.example.rickandmorty.retrofit.retrofit_model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "???",

    @SerializedName("status")
    val status: String = "???",

    @SerializedName("species")
    val species: String = "???",

    @SerializedName("type")
    val type: String = "???",

    @SerializedName("gender")
    val gender: String = "???",

    @SerializedName("origin")
    val origin: Location = Location("???", "???"),

    @SerializedName("location")
    val location: Location = Location("???", "???"),

    @SerializedName("image")
    val image: String = "???",

    @SerializedName("episode")
    val episode: List<String>,

    @SerializedName("url")
    val url: String = "???",

    @SerializedName("created")
    val created: String = "???"
)